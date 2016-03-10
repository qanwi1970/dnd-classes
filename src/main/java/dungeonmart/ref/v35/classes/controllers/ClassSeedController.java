package dungeonmart.ref.v35.classes.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dungeonmart.ref.v35.classes.entities.ClassCharacter;
import dungeonmart.ref.v35.classes.entities.ClassTable;
import dungeonmart.ref.v35.classes.entities.SeedClass;
import dungeonmart.ref.v35.classes.entities.SeedClassTable;
import dungeonmart.ref.v35.classes.repositories.ClassRepository;
import dungeonmart.ref.v35.classes.repositories.ClassTableRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
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

import static org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4;

@Slf4j
@RestController
@RequestMapping("/seed")
public class ClassSeedController {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    ClassTableRepository classTableRepository;

    @RequestMapping(path = "/class", method = RequestMethod.POST)
    public HttpEntity seedClasses() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File seedFile = new File(classLoader.getResource("seed/classes.json").getFile());
        List<SeedClass> seedClasses = mapper.readValue(seedFile, new TypeReference<List<SeedClass>>() {
        });
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
                    .epicFullText(unescapeHtml4(seedClass.getEpic_full_text()))
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
                    .fullText(unescapeHtml4(seedClass.getFull_text()))
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

    @RequestMapping(path = "/table", method = RequestMethod.POST)
    public HttpEntity seedClassTables() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File seedFile = new File(classLoader.getResource("seed/classtable.json").getFile());
        List<SeedClassTable> seedClassTables = mapper.readValue(seedFile, new TypeReference<List<SeedClassTable>>() {});
        for (SeedClassTable seedClassTable : seedClassTables) {
            log.info(seedClassTable.getName() + ":" + seedClassTable.getLevel());
            ClassTable classTable = ClassTable.builder()
                    .name(seedClassTable.getName())
                    .level(seedClassTable.getLevel())
                    .baseAttackBonus(seedClassTable.getBase_attack_bonus())
                    .fortitudeSave(seedClassTable.getFort_save())
                    .reflexSave(seedClassTable.getRef_save())
                    .willSave(seedClassTable.getWill_save())
                    .casterLevel(seedClassTable.getCaster_level())
                    .pointsPerDay(seedClassTable.getPoints_per_day())
                    .acBonus(seedClassTable.getAc_bonus())
                    .flurryOfBlows(seedClassTable.getFlurry_of_blows())
                    .bonusSpells(seedClassTable.getBonus_spells())
                    .powersKnown(seedClassTable.getPowers_known())
                    .unarmoredSpeedBonus(seedClassTable.getUnarmored_speed_bonus())
                    .unarmedDamage(seedClassTable.getUnarmed_damage())
                    .powerLevel(seedClassTable.getPower_level())
                    .special(seedClassTable.getSpecial())
                    .spellSlots0(seedClassTable.getSlots_0())
                    .spellSlots1(seedClassTable.getSlots_1())
                    .spellSlots2(seedClassTable.getSlots_2())
                    .spellSlots3(seedClassTable.getSlots_3())
                    .spellSlots4(seedClassTable.getSlots_4())
                    .spellSlots5(seedClassTable.getSlots_5())
                    .spellSlots6(seedClassTable.getSlots_6())
                    .spellSlots7(seedClassTable.getSlots_7())
                    .spellSlots8(seedClassTable.getSlots_8())
                    .spellSlots9(seedClassTable.getSlots_9())
                    .spellsKnown0(seedClassTable.getSpells_known_0())
                    .spellsKnown1(seedClassTable.getSpells_known_1())
                    .spellsKnown2(seedClassTable.getSpells_known_2())
                    .spellsKnown3(seedClassTable.getSpells_known_3())
                    .spellsKnown4(seedClassTable.getSpells_known_4())
                    .spellsKnown5(seedClassTable.getSpells_known_5())
                    .spellsKnown6(seedClassTable.getSpells_known_6())
                    .spellsKnown7(seedClassTable.getSpells_known_7())
                    .spellsKnown8(seedClassTable.getSpells_known_8())
                    .spellsKnown9(seedClassTable.getSpells_known_9())
                    .reference(seedClassTable.getReference())
                    .build();
            classTableRepository.save(classTable);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
