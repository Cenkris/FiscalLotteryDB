package Application.Model;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@ToString
@Setter
@Getter
@NoArgsConstructor
public class Code {
    private String id;
    private Date date;
    private int amount;
}
