package com.aiwan.server.user.role.skill.protocol;

import com.aiwan.server.user.role.skill.protocol.element.SkillElement;

import java.io.Serializable;

/**
 * @author dengzebiao
 * 查看技能栏
 */
public class SM_ViewSkillBar implements Serializable {
    private SkillElement[] skills;

    public SkillElement[] getSkills() {
        return skills;
    }

    public void setSkills(SkillElement[] skills) {
        this.skills = skills;
    }

    public static SM_ViewSkillBar valueOf(SkillElement[] skills) {
        SM_ViewSkillBar sm_viewSkillBar = new SM_ViewSkillBar();
        sm_viewSkillBar.setSkills(skills);
        return sm_viewSkillBar;
    }
}
