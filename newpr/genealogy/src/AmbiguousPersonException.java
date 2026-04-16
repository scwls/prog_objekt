public class AmbiguousPersonException extends Exception{
    private final PersonWithParentStrings person1;
    private final PersonWithParentStrings person2;
    public AmbiguousPersonException(PersonWithParentStrings person1, PersonWithParentStrings person2){
        this.person1=person1;
        this.person2=person2;
    }

    @Override
    public String getMessage() {
        return String.format("konflikt nazw:%s %s", person1, person2);
    }
}