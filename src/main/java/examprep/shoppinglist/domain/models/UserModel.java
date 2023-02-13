package examprep.shoppinglist.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    private Long id;

    private String username;

    private String password;
}
