package cs6310.Skill;

public class MockAttackContainer implements ISkillContainer {

    @Override
    public void addSkill(Skill skill) {
    }

    @Override
    public Skill choose(int choice) {
        return new Skill("Tackle", 5);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 1;
    }
    
}
