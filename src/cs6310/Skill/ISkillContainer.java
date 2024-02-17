package cs6310.Skill;

public interface ISkillContainer {
    void addSkill(Skill skill);
    Skill choose(int choice);
    int size();
}
