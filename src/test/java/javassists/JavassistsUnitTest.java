package javassists;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;
import javassist.bytecode.AccessFlag;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.Mnemonic;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class JavassistsUnitTest {
	
	@Test
    public void givenJavasisstAPI_whenConstructClass_thenGenerateAClassFile() throws CannotCompileException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // given
        String classNameWithPackage = "javassists.JavassistGeneratedClass";
        ClassFile cf = new ClassFile(false, classNameWithPackage, null);
        cf.setAccessFlags(AccessFlag.PUBLIC);
        cf.setInterfaces(new String[] { "java.lang.Cloneable" });

        FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
        f.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(f);

        // when
        String className = "JavassistGeneratedClass.class";
        cf.write(new DataOutputStream(new FileOutputStream(className)));

        // then
        ClassPool classPool = ClassPool.getDefault();
        Field[] fields = classPool.makeClass(cf).toClass().getFields();
        assertThat(fields[0].getName()).isEqualTo("id");

        String classContent = new String(Files.readAllBytes(Paths.get(className)));
        assertThat(classContent.contains("java/lang/Cloneable"));
    }

    @Test
    public void givenJavaClass_whenLoadAtByJavassist_thenTraversWholeClass() throws NotFoundException, CannotCompileException, BadBytecode {
        // given
        ClassPool cp = ClassPool.getDefault();
        ClassFile cf = cp.get("javassists.Point").getClassFile();
        MethodInfo minfo = cf.getMethod("move");
        CodeAttribute ca = minfo.getCodeAttribute();
        CodeIterator ci = ca.iterator();

        // when
        List<String> operations = new LinkedList<>();
        while (ci.hasNext()) {
            int index = ci.next();
            int op = ci.byteAt(index);
            operations.add(Mnemonic.OPCODE[op]);
        }

        // then
        assertThat(operations).isEqualTo(Arrays.asList("aload_0", "iload_1", "putfield", "aload_0", "iload_2", "putfield", "return"));

    }

    @Test
    public void givenTableOfInstructions_whenAddNewInstruction_thenShouldConstructProperSequence() throws NotFoundException, BadBytecode, CannotCompileException, IllegalAccessException, InstantiationException {
        // given
        ClassFile cf = ClassPool.getDefault().get("javassists.ThreeDimensionalPoint").getClassFile();

        // when
        FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
        f.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(f);

        ClassPool classPool = ClassPool.getDefault();
        Field[] fields = classPool.makeClass(cf).getClass().getFields();
        List<String> fieldsList = Stream.of(fields).map(Field::getName).collect(Collectors.toList());
        assertThat(fieldsList.contains("id"));

    }

    @Test
    public void givenLoadedClass_whenAddConstructorToClass_shouldCreateClassWithConstructor() throws NotFoundException, CannotCompileException, BadBytecode {
        // given
        ClassFile cf = ClassPool.getDefault().get("javassists.Point").getClassFile();
        Bytecode code = new Bytecode(cf.getConstPool());
        code.addAload(0);
        code.addInvokespecial("java/lang/Object", MethodInfo.nameInit, "()V");
        code.addReturn(null);

        // when
        MethodInfo minfo = new MethodInfo(cf.getConstPool(), MethodInfo.nameInit, "()V");
        minfo.setCodeAttribute(code.toCodeAttribute());
        cf.addMethod(minfo);

        // then
        CodeIterator ci = code.toCodeAttribute().iterator();
        List<String> operations = new LinkedList<>();
        while (ci.hasNext()) {
            int index = ci.next();
            int op = ci.byteAt(index);
            operations.add(Mnemonic.OPCODE[op]);
        }

        assertThat(operations).isEqualTo(Arrays.asList("aload_0", "invokespecial", "return"));

    }

}
