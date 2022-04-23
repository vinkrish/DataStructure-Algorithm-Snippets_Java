package pdf.renderer;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.ColumnDocumentRenderer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;

public class NewsPaper {
	
	public static final String DEST = "results/pdf/newspaper.pdf";

    public static final String APPLE_IMG = "src/main/resources/img/newspaper_apple.jpeg";
    public static final String APPLE_TXT = "Apple employees are already discussing what they will do if ordered to help law enforcement authorities. Some say they may balk at the work, while others may even quit their high-paying jobs rather than undermine the security of the software they have already created, according to more than a half-dozen current and former Apple employees. Among those interviewed were Apple engineers who are involved in the development of mobile products and security, as well as former security engineers and executives. The potential resistance adds a wrinkle to a very public fight between Apple, the world’s most valuable company, and the authorities over access to an iPhone used by one of the attackers in the December mass killing in San Bernardino, Calif.";
    public static final String FACEBOOK_IMG = "src/main/resources/img/newspaper_fb.jpeg";
    public static final String FACEBOOK_TXT = "In a Friday morning post, Facebook’s co-founder and chief executive, Mark Zuckerberg, announced his arrival in Beijing with a blithe message about what must have been a dizzying jog through the center of China’s capital, which has been suffering from a weeklong bout of hazardous air pollution.";
    public static final String INST_IMG = "src/main/resources/img/newspaper_insta.jpeg";
    public static final String INST_TXT = "That could mean that if your best friend posted a photo of her new Bernese mountain dog’s puppies five hours ago while you were on a flight without Internet connectivity, Instagram might place that image at the top of your feed the next time you open the app. Based on your history of interaction with that friend, Instagram knows you probably would not want to miss that picture.";

    static PdfFont timesNewRoman = null;
    static PdfFont timesNewRomanBold = null;

    public static void main(String[] args) throws Exception {
        timesNewRoman = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        timesNewRomanBold = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new NewsPaper().createPdf(DEST);
    }

    protected void createPdf(String dest) throws Exception {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;

        // Initialize document
        Document document = new Document(pdf, ps);

        //Set column parameters
        float offSet = 36;
        float columnWidth = (ps.getWidth() - offSet * 2 + 10) / 3;
        float columnHeight = ps.getHeight() - offSet * 2;

        //Define column areas
        Rectangle[] columns = {new Rectangle(offSet - 5, offSet, columnWidth, columnHeight),
                new Rectangle(offSet + columnWidth, offSet, columnWidth, columnHeight),
                new Rectangle(offSet + columnWidth * 2 + 5, offSet, columnWidth, columnHeight)};
        document.setRenderer(new ColumnDocumentRenderer(document, columns));

        Image apple = new Image(ImageDataFactory.create(APPLE_IMG)).setWidth(columnWidth);
//        String articleApple = new String(Files.readAllBytes(Paths.get(APPLE_TXT)), StandardCharsets.UTF_8);
        NewsPaper.addArticle(document, "Apple Encryption Engineers, if Ordered to Unlock iPhone, Might Resist", "By JOHN MARKOFF MARCH 18, 2016", apple, APPLE_TXT);
        Image facebook = new Image(ImageDataFactory.create(FACEBOOK_IMG)).setWidth(columnWidth);
//        String articleFB = new String(Files.readAllBytes(Paths.get(FACEBOOK_TXT)), StandardCharsets.UTF_8);
        NewsPaper.addArticle(document, "With \"Smog Jog\" Through Beijing, Zuckerberg Stirs Debate on Air Pollution", "By PAUL MOZUR MARCH 18, 2016", facebook, FACEBOOK_TXT);
        Image inst = new Image(ImageDataFactory.create(INST_IMG)).setWidth(columnWidth);
//        String articleInstagram = new String(Files.readAllBytes(Paths.get(INST_TXT)), StandardCharsets.UTF_8);
        NewsPaper.addArticle(document, "Instagram May Change Your Feed, Personalizing It With an Algorithm","By MIKE ISAAC MARCH 15, 2016", inst, INST_TXT);

        document.close();

    }

    public static void addArticle(Document doc, String title, String author, Image img, String text) throws IOException {
        Paragraph p1 = new Paragraph(title)
                .setFont(timesNewRomanBold)
                .setFontSize(14);
        doc.add(p1);
        doc.add(img);
        Paragraph p2 = new Paragraph()
                .setFont(timesNewRoman)
                .setFontSize(7)
                .setFontColor(ColorConstants.GRAY)
                .add(author);
        doc.add(p2);
        Paragraph p3 = new Paragraph()
                .setFont(timesNewRoman)
                .setFontSize(10)
                .add(text);
        doc.add(p3);
    }

}
