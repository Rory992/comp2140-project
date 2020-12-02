package paysys;

/**
 * @author Rory Young
 */
public abstract class Person {
    protected int trn;
    protected int nis;
    protected int yob;
    protected char gender;

    /**
     * @param trn
     * @param nis
     * @param yob
     * @param gender
     */
    public Person (int trn, int nis, int yob, char gender) {
        this.trn = trn;
        this.nis = nis;
        this.yob = yob;
        this.gender = gender;
    }

    /**
     * @return
     */
    public int getTRN() {
        return this.trn;
    }

    /**
     * @return
     */
    public int getNIS() {
        return this.nis;
    }

    /**
     * @return
     */
    public int getYOB() {
        return this.yob;
    }

    /**
     * @return
     */
    public char getGender() {
        return this.gender;
    }

    /**
     * @param num
     */
    public void setTRN(int num) {
        this.trn = num;
    }

    /**
     * @param num
     */
    public void setNIS(int num) {
        this.nis = num;
    }

    /**
     * @param num
     */
    public void setYOB(int num) {
        this.yob = num;
    }

    /**
     * @param sex
     */
    public void setGender(char sex) {
        this.gender = sex;
    }
}
