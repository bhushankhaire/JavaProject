package com.basic.threads.file.handling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;


public class FileHandling {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\bhushan\\IdeaProjects\\JavaProject\\src\\com\\basic\\threads\\file\\handling\\logFile.txt");
        long start=System.currentTimeMillis();
        Files.lines(path).map((line) -> {
            return convertToObject(line);
        }).sorted((e1,e2)-> {
            return e1.getId().compareTo(e2.getId());
        }).forEach(System.out::println);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        start=System.currentTimeMillis();
        Map<String, List<Data>> data1=Files.lines(path).map((line) -> {
            return convertToObject(line);
        }).collect(Collectors.groupingBy(Data::getId,Collectors.toList()));
        System.out.println(data1);
        end=System.currentTimeMillis();
        System.out.println(end-start);
        Map<String, List<Long>> data2=Files.lines(path).map((line) -> {
            return convertToObject(line);
        }).collect(Collectors.groupingBy(Data::getId,mapping(Data::getTimestamp,Collectors.toList())));
        System.out.println(data2);
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static Data convertToObject(String line) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Data data = mapper.readValue(line, Data.class);
            return data;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
