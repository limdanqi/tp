package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.studyspot.StudySpot;
import seedu.address.model.studyspot.UniqueStudySpotList;

/**
 * Wraps all data at the study-tracker level
 * Duplicates are not allowed (by .isSameStudySpot comparison)
 */
public class StudyTracker implements ReadOnlyStudyTracker {

    private final UniqueStudySpotList studySpots;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        studySpots = new UniqueStudySpotList();
    }

    public StudyTracker() {}

    /**
     * Creates an StudyTracker using the StudySpots in the {@code toBeCopied}
     */
    public StudyTracker(ReadOnlyStudyTracker toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the study spot list with {@code studySpots}.
     * {@code studySpots} must not contain duplicate study spots.
     */
    public void setStudySpots(List<StudySpot> studySpots) {
        this.studySpots.setStudySpots(studySpots);
    }

    /**
     * Resets the existing data of this {@code StudyTracker} with {@code newData}.
     */
    public void resetData(ReadOnlyStudyTracker newData) {
        requireNonNull(newData);

        setStudySpots(newData.getStudySpotList());
    }

    //// study spot-level operations

    /**
     * Returns true if a study spot with the same identity as {@code studySpot} exists in the study tracker.
     */
    public boolean hasStudySpot(StudySpot studySpot) {
        requireNonNull(studySpot);
        return studySpots.contains(studySpot);
    }

    /**
     * Adds a study spot to the study tracker.
     * The study spot must not already exist in the study tracker.
     */
    public void addStudySpot(StudySpot p) {
        studySpots.add(p);
    }

    /**
     * Replaces the given study spot {@code target} in the list with {@code editedStudySpot}.
     * {@code target} must exist in the study tracker.
     * The study spot identity of {@code editedStudySpot} must not
     * be the same as another existing study spot in the study tracker.
     */
    public void setStudySpot(StudySpot target, StudySpot editedStudySpot) {
        requireNonNull(editedStudySpot);

        studySpots.setStudySpot(target, editedStudySpot);
    }

    /**
     * Removes {@code key} from this {@code StudyTracker}.
     * {@code key} must exist in the study tracker.
     */
    public void removeStudySpot(StudySpot key) {
        studySpots.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return studySpots.asUnmodifiableObservableList().size() + " study spots";
        // TODO: refine later
    }

    @Override
    public ObservableList<StudySpot> getStudySpotList() {
        return studySpots.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StudyTracker // instanceof handles nulls
                && studySpots.equals(((StudyTracker) other).studySpots));
    }

    @Override
    public int hashCode() {
        return studySpots.hashCode();
    }
}
