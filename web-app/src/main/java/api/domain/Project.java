package api.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message="Name cannot be blank")
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Set<Sprint> sprints;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Set<User> users;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Set<Task> backlog;
    @OneToOne
    private User productOwner;

    public User getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(User productOwner) {
        this.productOwner = productOwner;
    }

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Set<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(Set<Sprint> sprints) {
        this.sprints = sprints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Set<Task> getBacklog() {
        return backlog;
    }

    public void setBacklog(Set<Task> backlog) {
        this.backlog = backlog;
    }

    public void addTaskToBacklog(Task task) {
        this.backlog.add(task);
    }
}
