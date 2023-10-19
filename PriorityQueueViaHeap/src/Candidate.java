/**
 The Candidate class represents a candidate object with a last name, full name, and percentage value.
 It implements the Comparable interface to compare Candidate objects based on their percentage values.
 */

public class Candidate implements Comparable<Candidate> {
    private String lastName;
    private String fullName;
    private double pct;

    /**
     Constructs a new Candidate object with the given parameters.
     @param lastName The candidate's last name.
     @param fullName The candidate's full name.
     @param pct The candidate's percentage score.
     */
    public Candidate(String lastName, String fullName, double pct) {
        this.lastName = lastName;
        this.fullName = fullName;
        this.pct = pct;
    }

    /**
     Returns the candidate's last name.
     @return The candidate's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     Returns the candidate's full name.
     @return The candidate's full name.
     */
    public String getFullName() {
        return fullName;
    }
    /**
     Returns the candidate's percentage score.
     @return The candidate's percentage score.
     */
    public double getPct() {
        return pct;
    }
    /**
     Sets the candidate's percentage score to the given value.
     @param pct The new percentage score.
     */

    public void setPct(double pct) {
        this.pct = pct;
    }
/**

 Compares this Candidate object to another Candidate object based on their percentage score.
 @param other The other Candidate object to compare to.
 @return A negative integer if this candidate has a lower score, zero if they have the same score,    or a positive integer if this candidate has a higher score.
 */

 @Override
    public int compareTo(Candidate other) {
        // Compare by polling numbers
        if (this.pct < other.pct) {
            // If this candidate's polling number is greater, return 1
            // to indicate this candidate should come before the other candidate
            return -1;
        } else if (this.pct > other.pct) {
            // If this candidate's polling number is smaller, return -1
            // to indicate this candidate should come after the other candidate
            return 1;
        } else {
            // If polling numbers are tied, compare by last name
            // using lexicographic comparison
            return this.lastName.compareTo(other.lastName);
        }
    }

    /**
     Overrides the default toString() method to return a String representation of the Candidate object.
     @return A String in the format "fullName:pct".
     */
    @Override
    public String toString() {
        return fullName + ":" + pct;
    }
}



