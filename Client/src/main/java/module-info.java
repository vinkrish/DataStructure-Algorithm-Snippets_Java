module com.vinkrish.student.client
{
	requires com.vinkrish.student.model;
	requires com.vinkrish.student.service;
	requires com.vinkrish.student.service.dbimpl;
	uses com.vinkrish.student.service.StudentService;
}