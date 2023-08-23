package naverOpenAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BookDTO {
    private String title;
    private int price;
    private String company;
    private int page;
}
