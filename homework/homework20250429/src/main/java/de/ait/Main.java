package de.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("http://jsonplaceholder.typicode.com/comments");
        ResponseEntity<ArrayList<Comment>> response =
                restTemplate.exchange(request, new ParameterizedTypeReference<ArrayList<Comment>>() { });

        ArrayList<Comment> comments = response.getBody();

        if (comments != null) {
            comments.forEach(System.out::println);
        } else {
            System.out.println("Комментарии не получены");
        }

    }
}