package dungeonmart.ref.v35.classes.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dungeonmart.ref.v35.classes.entities.ClassCharacter;
import dungeonmart.ref.v35.classes.entities.SeedClass;
import dungeonmart.ref.v35.classes.repositories.ClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/seed")
public class ClassSeedController {

    @Autowired
    ClassRepository classRepository;

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity seedClasses() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File seedFile = new File(classLoader.getResource("seed/classes.json").getFile());
        List<SeedClass> seedClasses = mapper.readValue(seedFile, new TypeReference<List<SeedClass>>(){});
        for (SeedClass seedClass : seedClasses) {
            log.info(seedClass.getName());
            ClassCharacter classCharacter = ClassCharacter.builder()
                    .name(seedClass.getName())
                    .type(seedClass.getType())
                    .alignment(seedClass.getAlignment())
                    .hitDie(seedClass.getHit_die())
                    .classSkills(seedClass.getClass_skills())
                    .skillPoints(seedClass.getSkill_points())
                    .skillPointsAbility(seedClass.getSkill_points_ability())
                    .spellStat(seedClass.getSpell_stat())
                    .proficiencies(seedClass.getProficiencies())
                    .spellType(seedClass.getSpell_type())
                    .epicFeatBaseLevel(seedClass.getEpic_feat_base_level())
                    .epicFeatInterval(seedClass.getEpic_feat_interval())
                    .epicFeatList(seedClass.getEpic_feat_list())
                    .epicFullText(seedClass.getEpic_full_text())
                    .requiredRace(seedClass.getReq_race())
                    .requiredWeaponProficiency(seedClass.getReq_weapon_proficiency())
                    .requiredBaseAttackBonus(seedClass.getReq_base_attack_bonus())
                    .requiredSkill(seedClass.getReq_skill())
                    .requiredFeat(seedClass.getReq_feat())
                    .requiredSpells(seedClass.getReq_spells())
                    .requiredLanguages(seedClass.getReq_languages())
                    .requiredPsionics(seedClass.getReq_psionics())
                    .requiredEpicFeat(seedClass.getReq_epic_feat())
                    .requiredSpecial(seedClass.getReq_special())
                    .spellList1(seedClass.getSpell_list_1())
                    .spellList2(seedClass.getSpell_list_2())
                    .spellList3(seedClass.getSpell_list_3())
                    .spellList4(seedClass.getSpell_list_4())
                    .spellList5(seedClass.getSpell_list_5())
                    .fullText(seedClass.getFull_text())
                    .reference(seedClass.getReference())
                    .createdBy("seed")
                    .createdTime(Instant.now().getEpochSecond())
                    .modifiedBy("seed")
                    .modifiedTime(Instant.now().getEpochSecond())
                    .seedData(true)
                    .build();
            classRepository.save(classCharacter);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
