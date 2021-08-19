module com.vinkrish.student.service.dbimpl
{
	requires com.vinkrish.student.model;
	
	requires transitive com.vinkrish.student.service;
	
//	provides com.vinkrish.student.service.StudentService with com.vinkrish.student.service.dbimpl.StudentDbService;

	requires java.logging;
	
	exports com.vinkrish.student.service.dbimpl;
}