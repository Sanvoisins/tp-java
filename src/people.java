public class people {
    private Integer id;
    private String first_name;
    private String last_name;
    private jobs job;
    private birthDate birth_date;
    private String nationality;

    public people(Integer id, String first_name, String last_name, jobs job, birthDate birth_date, String nationality) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.job = job;
        this.birth_date = birth_date;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        if(this.job == jobs.DIRECTOR) {
            return this.first_name + " " + this.last_name + " is a " + this.job + " born in " + this.birth_date + " and have " + this.nationality + " nationality.";
        } else {
            return this.first_name + " " + this.last_name + " is an " + this.job + " born in " + this.birth_date + " and have " + this.nationality + " nationality.";
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public jobs getJob() {
        return job;
    }

    public void setJob(jobs job) {
        this.job = job;
    }

    public birthDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(birthDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
