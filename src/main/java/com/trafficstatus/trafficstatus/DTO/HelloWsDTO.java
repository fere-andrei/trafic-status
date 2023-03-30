package com.trafficstatus.trafficstatus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class HelloWsDTO {

    private String content;
    private long id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HelloWsDTO(String content, long id) {
        this.content = content;
        this.id = id;
    }
}
