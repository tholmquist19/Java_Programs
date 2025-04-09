package cscd212enums;

public enum DifficultyLevel {

    EASY(0.7), HARD(1.5), INSANE(2), NORMAL(1);

    private double difficultyModifier;

    private DifficultyLevel(final double difficultyModifier){
        if(difficultyModifier<=0)
            throw new IllegalArgumentException("Illegal params in difficulty level constructor");
        this.difficultyModifier = difficultyModifier;
    }
    public double getModifier(){
        return this.difficultyModifier;
    }


}
