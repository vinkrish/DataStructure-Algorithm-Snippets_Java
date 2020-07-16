## Pattern Groups

- Creational
- Structural
- Behavioral

| **Creational** | Example |
| -------------- | ------- |
| Singleton | <ul><li>Runtime</li><li>Logger</li><li>Spring Beans</li><li>Graphic Managers</li></ul> |
| Builder | <ul><li>StringBuilder</li><li>DocumentBuilder</li><li>Locale.Builder</li></ul> |
| Factory | <ul><li>Calendar</li><li>ResourceBundle</li><li>NumberFormat</li></ul> |
| Prototype | <ul><li>Inspiration: Object clone method</li></ul> |
| AbstractFactory | <ul><li>DocumentBuilder</li><li>Frameworks</li></ul> |

| **Structural** | Example |
| -------------- | ------- |
| Adapter | <ul><li>Arrays -> Lists</li><li>Streams</li></ul> |
| Decorator | <ul><li>InputStream</li><li>Collections#CheckedList</li><li>UI Component</li></ul> |
| Facade | <ul><li>java.net.URL</li><li>javax.faces.context.FacesContext</li></ul> |
| Bridge | <ul><li>Driver</li><li>JDBC</li></ul> |
| Composite | <ul><li>RESTful service GETs</li><li>JSF widgets</li><li>java.AWT.Component</li></ul> |
| Flyweight | <ul><li>String</li><li>Integer#valueOf(int)</li><li>Boolean, Byte, Character, Short, Long</li></ul> |
| Proxy | <ul><li>java.lang.reflect.Proxy</li><li>java.rmi.*</li></ul> |

| **Behavioral** | Example |
| -------------- | ------- |
| Observer | <ul><li>java.util.Observer</li><li>java.util.EventListener</li><li>javax.jms.Topic</li></ul> |
| Strategy | <ul><li>Comparator</li></ul> |
| Mediator | <ul><li>java.util.Timer</li><li>reflect.Method#invoke()</li></ul> |
| Command | <ul><li>Runnable</li><li>javax.swing.Action</li></ul> |
| Chain of Responsibility | <ul><li>Logger#Log()</li><li>javax.servlet.Filter#doFilter()</li><li>Spring Security Filter Chain</li></ul> |
| Memento | <ul><li>java.util.Date</li><li>Serializable</li></ul> |
| Interpreter | <ul><li>java.util.Pattern</li><li>java.text.Format</li></ul> |
| Visitor | <ul><li>java.lang.model.elemment.Element</li><li>java.lang.model.elemment.ElementVisitor</li></ul> |
| Template Method | <ul><li>Collections#sort()</li><li>AbstractList#indexOf()</li></ul> |