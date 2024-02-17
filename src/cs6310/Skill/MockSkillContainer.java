package cs6310.Skill;

import java.util.ArrayList;
import java.util.List;

public class MockSkillContainer implements ISkillContainer {
    private List<Skill> skills;

    public MockSkillContainer() {
        skills = new ArrayList<>();
    }

    @Override
    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    @Override
    public Skill choose(int choice) {
        return skills.get(choice);
    }

    @Override
    public int size() {
        return skills.size();
    }
}
