package pk.waqaskhawaja.ma.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DataRecord.
 */
@Entity
@Table(name = "data_record")
@Document(indexName = "datarecord")
public class DataRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "text")
    private String text;

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "jhi_time")
    private Integer time;

    @ManyToOne
    @JsonIgnoreProperties("dataRecords")
    private Session session;

    @ManyToOne
    @JsonIgnoreProperties("dataRecords")
    private InteractionType interactionType;

    @ManyToMany(mappedBy = "dataRecords")
    @JsonIgnore
    private Set<Annotation> annotations = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public DataRecord duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getText() {
        return text;
    }

    public DataRecord text(String text) {
        this.text = text;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSourceId() {
        return sourceId;
    }

    public DataRecord sourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getTime() {
        return time;
    }

    public DataRecord time(Integer time) {
        this.time = time;
        return this;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Session getSession() {
        return session;
    }

    public DataRecord session(Session session) {
        this.session = session;
        return this;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public InteractionType getInteractionType() {
        return interactionType;
    }

    public DataRecord interactionType(InteractionType interactionType) {
        this.interactionType = interactionType;
        return this;
    }

    public void setInteractionType(InteractionType interactionType) {
        this.interactionType = interactionType;
    }

    public Set<Annotation> getAnnotations() {
        return annotations;
    }

    public DataRecord annotations(Set<Annotation> annotations) {
        this.annotations = annotations;
        return this;
    }

    public DataRecord addAnnotation(Annotation annotation) {
        this.annotations.add(annotation);
        annotation.getDataRecords().add(this);
        return this;
    }

    public DataRecord removeAnnotation(Annotation annotation) {
        this.annotations.remove(annotation);
        annotation.getDataRecords().remove(this);
        return this;
    }

    public void setAnnotations(Set<Annotation> annotations) {
        this.annotations = annotations;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataRecord dataRecord = (DataRecord) o;
        if (dataRecord.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dataRecord.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DataRecord{" +
            "id=" + getId() +
            ", duration=" + getDuration() +
            ", text='" + getText() + "'" +
            ", sourceId='" + getSourceId() + "'" +
            ", time=" + getTime() +
            "}";
    }
}
