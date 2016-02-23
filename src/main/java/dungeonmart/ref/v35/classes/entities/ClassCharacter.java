package dungeonmart.ref.v35.classes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClassCharacter implements Serializable {

    @Id
    @GeneratedValue()
    private String classCharacterId;

    @NotBlank
    private String name;

    private String type;

    private String alignment;

    private String hitDie;

    private String classSkills;

    private String skillPoints;

    private String skillPointsAbility;

    private String spellStat;

    private String proficiencies;

    private String spellType;

    private String epicFeatBaseLevel;

    private String epicFeatInterval;

    private String epicFeatList;

    private String epicFullText;

    private String requiredRace;

    private String requiredWeaponProficiency;

    private String requiredBaseAttackBonus;

    private String requiredSkill;

    private String requiredFeat;

    private String requiredSpells;

    private String requiredLanguages;

    private String requiredPsionics;

    private String requiredEpicFeat;

    private String requiredSpecial;

    private String spellList1;

    private String spellList2;

    private String spellList3;

    private String spellList4;

    private String spellList5;

    private String fullText;

    private String reference;

    private String createdBy;

    private Instant createdTime;

    private String modifiedBy;

    private Instant modifiedTime;

    private boolean seedData;

}
