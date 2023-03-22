package hellojpa;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR",
                   sequenceName = "SEQ_MEMBER_PK",
                   initialValue = 1,
                   allocationSize = 50)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

//    @Column(name = "team_id")
//    private Long teamId;

    @ManyToOne  // Member : Team = N:1
    @JoinColumn(name = "team_id")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
