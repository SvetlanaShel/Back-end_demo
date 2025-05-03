/*

# 1
Ваша задача написать используя API https://api.imagga.com эндпоинт /text написать программу которая распознает
текст на картинке. Для тестирования можно использовать
картинку https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg
Результат для этой картинки строка: "ОТВЕЧАЮ В СПРИНГЕ ЭТО УЖЕ ЕСТЬ"

 */

package de.ait;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        String imgUrl = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
        String token = "Basic YWNjX2Y4ZmQ3MzQ1ZDc3MjY1YjozNDIxY2Y0NGM1ODdmMzk4M2M2NzdhMDYzNzlkYTk1Ng==";
        String url ="https://api.imagga.com/v2/text";

        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
           headers.add("Authorization", token);



        URI uri = UriComponentsBuilder.fromUriString(url)
               .queryParam("image_url", imgUrl)
               .build()
               .toUri();


        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<DataDto> response = restTemplate.exchange(request, DataDto.class);

        response.getBody().getResult().getText().forEach(System.out::println);

    }
}










