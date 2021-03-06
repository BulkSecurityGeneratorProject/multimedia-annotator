package pk.waqaskhawaja.ma.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.InstantFilter;
import org.springframework.data.elasticsearch.core.query.Criteria;

/**
 * Criteria class for the {@link pk.waqaskhawaja.ma.domain.Annotation} entity. This class is used
 * in {@link pk.waqaskhawaja.ma.web.rest.AnnotationResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /annotations?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class AnnotationCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private InstantFilter start;

    private InstantFilter end;

    private StringFilter annotationText;

    private LongFilter annotationSessionId;

    private LongFilter interactionRecordId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public InstantFilter getStart() {
        return start;
    }

    public void setStart(InstantFilter start) {
        this.start = start;
    }

    public InstantFilter getEnd() {
        return end;
    }

    public void setEnd(InstantFilter end) {
        this.end = end;
    }

    public StringFilter getAnnotationText() {
        return annotationText;
    }

    public void setAnnotationText(StringFilter annotationText) {
        this.annotationText = annotationText;
    }

    public LongFilter getAnnotationSessionId() {
        return annotationSessionId;
    }

    public void setAnnotationSessionId(LongFilter annotationSessionId) {
        this.annotationSessionId = annotationSessionId;
    }

    public LongFilter getInteractionRecordId() {
        return interactionRecordId;
    }

    public void setInteractionRecordId(LongFilter interactionRecordId) {
        this.interactionRecordId = interactionRecordId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AnnotationCriteria that = (AnnotationCriteria) o;
        return
            Objects.equals(id, that.id) &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end) &&
                Objects.equals(annotationText, that.annotationText) &&
                Objects.equals(annotationSessionId, that.annotationSessionId) &&
                Objects.equals(interactionRecordId, that.interactionRecordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            start,
            end,
            annotationText,
            annotationSessionId,
            interactionRecordId
        );
    }

    @Override
    public String toString() {
        return "AnnotationCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (start != null ? "start=" + start + ", " : "") +
            (end != null ? "end=" + end + ", " : "") +
            (annotationText != null ? "annotationText=" + annotationText + ", " : "") +
            (annotationSessionId != null ? "annotationSessionId=" + annotationSessionId + ", " : "") +
            (interactionRecordId != null ? "interactionRecordId=" + interactionRecordId + ", " : "") +
            "}";
    }

}
