package java11;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))
            .GET()
            .build();
        
        // Synchronous send() method, blocks until response is received
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
        
        // Asynchronous sendAsync() method
        CompletableFuture<HttpResponse<String>> responseFuture = 
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Create a ResponseHolder object to store the parsed result
        ResponseHolder<Post> postHolder = new ResponseHolder<>();
        // Process the response when it's available using thenApply()
        responseFuture.thenApply(HttpResponse::body)
        			  .thenApply(HttpClientExample::parseJson)
//					  .thenApply(json -> JsonAsyncHttpClientExample.parseJson(json)); //if using lambda expression
        			  .thenApply(post -> {
        			        System.out.println("Post Title: " + post.title);
        			        return post;  // Pass the post object to the next stage
        			    })
//        			  .thenAccept(post -> System.out.println("Post Title: " + post.title)) //terminal operation
        			  .thenAccept(post -> {
        				  // Perform multiple actions here
                          postHolder.setResponse(post);
                      })
                      .join(); // Join blocks the current thread until the future completes

        // You can now access the response from the holder and pass it around
        Post post = postHolder.getResponse();
        if (post != null) {
            System.out.println("Post Title: " + post.title);
        }
    }
    
    // Create a ResponseHolder class to hold the result
    static class ResponseHolder<T> {
        private T response;

        public void setResponse(T response) {
            this.response = response;
        }

        public T getResponse() {
            return response;
        }
    }
    
    // Custom class to map JSON response
    static class Post {
        public int id;
        public int userId;
        public String title;
        public String body;
    }

    // Method to parse JSON into a Post object using Jackson
    private static Post parseJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Post.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/* 
 * thenAccept() is a terminal operation, meaning it does not return the result to the next step in the chain.
 */
