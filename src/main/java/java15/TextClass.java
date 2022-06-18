package java15;

public class TextClass {
	public static void main(String[] args) {
		String html = """
	              <html>
	                  <body>
	                      <p>Hello, World!</p>
	                  </body>
	              </html>
	              """;
		System.out.println(html);
		
		String name = "World";
		String greeting = """
		                  Hello, %s!
		                  """.formatted(name);
		System.out.println(greeting);
		
		String htmlTextBlock = "<html>   \n"+
                "\t<body>\t\t \n"+
                    "\t\t<p>Hello</p>  \t \n"+
                "\t</body> \n"+
            "</html>";
		System.out.println(htmlTextBlock.replace(" ", "*"));
		System.out.println(htmlTextBlock.stripIndent().replace(" ", "*"));
	}
}
/*
	Text blocks are multiline string literals that make it easier to work with multi-line strings, 
	improving readability and reducing the need for escape sequences.
*/