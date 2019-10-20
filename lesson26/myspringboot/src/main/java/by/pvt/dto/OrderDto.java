package by.pvt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class OrderDto {

    private long orderId;
    private double price;
    private int count;
    private String comment;
    private Date date;

}
