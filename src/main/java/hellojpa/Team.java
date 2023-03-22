package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    // Team : Member = 1:N
    // mappedBy : 반대쪽 객체에서 연관되어 있는 필드명
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();   // NPE 방지하기 위해 초기화

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
