package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Item {
    private int id;
    private String title;
    private double price;
    private String picUrl;
    private User user;
    private Category category;
}
