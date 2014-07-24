// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: enums/enums.proto

package dota.enums;

public final class Enums {
  private Enums() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  /**
   * Protobuf enum {@code AttackType}
   *
   * <pre>
   * 攻击类型
   * </pre>
   */
  public enum AttackType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>PHYSICAL = 1;</code>
     *
     * <pre>
     * 物理伤害
     * </pre>
     */
    PHYSICAL(0, 1),
    /**
     * <code>MAGICAL = 2;</code>
     *
     * <pre>
     * 魔法伤害
     * </pre>
     */
    MAGICAL(1, 2),
    ;

    /**
     * <code>PHYSICAL = 1;</code>
     *
     * <pre>
     * 物理伤害
     * </pre>
     */
    public static final int PHYSICAL_VALUE = 1;
    /**
     * <code>MAGICAL = 2;</code>
     *
     * <pre>
     * 魔法伤害
     * </pre>
     */
    public static final int MAGICAL_VALUE = 2;


    public final int getNumber() { return value; }

    public static AttackType valueOf(int value) {
      switch (value) {
        case 1: return PHYSICAL;
        case 2: return MAGICAL;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<AttackType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<AttackType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<AttackType>() {
            public AttackType findValueByNumber(int number) {
              return AttackType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dota.enums.Enums.getDescriptor().getEnumTypes().get(0);
    }

    private static final AttackType[] VALUES = values();

    public static AttackType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private AttackType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:AttackType)
  }

  /**
   * Protobuf enum {@code CombatState}
   *
   * <pre>
   * 战斗状态
   * </pre>
   */
  public enum CombatState
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>STUN = 1;</code>
     *
     * <pre>
     * 眩晕
     * </pre>
     */
    STUN(0, 1),
    /**
     * <code>EMITTINT = 2;</code>
     *
     * <pre>
     * 持续施法中
     * </pre>
     */
    EMITTINT(1, 2),
    /**
     * <code>BE_EMITTING = 3;</code>
     *
     * <pre>
     * 被持续施法的技能限制
     * </pre>
     */
    BE_EMITTING(2, 3),
    ;

    /**
     * <code>STUN = 1;</code>
     *
     * <pre>
     * 眩晕
     * </pre>
     */
    public static final int STUN_VALUE = 1;
    /**
     * <code>EMITTINT = 2;</code>
     *
     * <pre>
     * 持续施法中
     * </pre>
     */
    public static final int EMITTINT_VALUE = 2;
    /**
     * <code>BE_EMITTING = 3;</code>
     *
     * <pre>
     * 被持续施法的技能限制
     * </pre>
     */
    public static final int BE_EMITTING_VALUE = 3;


    public final int getNumber() { return value; }

    public static CombatState valueOf(int value) {
      switch (value) {
        case 1: return STUN;
        case 2: return EMITTINT;
        case 3: return BE_EMITTING;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<CombatState>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<CombatState>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<CombatState>() {
            public CombatState findValueByNumber(int number) {
              return CombatState.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dota.enums.Enums.getDescriptor().getEnumTypes().get(1);
    }

    private static final CombatState[] VALUES = values();

    public static CombatState valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private CombatState(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:CombatState)
  }

  /**
   * Protobuf enum {@code HeroType}
   *
   * <pre>
   * 英雄类型
   * </pre>
   */
  public enum HeroType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>STRENGTH = 1;</code>
     */
    STRENGTH(0, 1),
    /**
     * <code>AGILITY = 2;</code>
     */
    AGILITY(1, 2),
    /**
     * <code>INTELLIGENCE = 3;</code>
     */
    INTELLIGENCE(2, 3),
    ;

    /**
     * <code>STRENGTH = 1;</code>
     */
    public static final int STRENGTH_VALUE = 1;
    /**
     * <code>AGILITY = 2;</code>
     */
    public static final int AGILITY_VALUE = 2;
    /**
     * <code>INTELLIGENCE = 3;</code>
     */
    public static final int INTELLIGENCE_VALUE = 3;


    public final int getNumber() { return value; }

    public static HeroType valueOf(int value) {
      switch (value) {
        case 1: return STRENGTH;
        case 2: return AGILITY;
        case 3: return INTELLIGENCE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<HeroType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<HeroType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<HeroType>() {
            public HeroType findValueByNumber(int number) {
              return HeroType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dota.enums.Enums.getDescriptor().getEnumTypes().get(2);
    }

    private static final HeroType[] VALUES = values();

    public static HeroType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private HeroType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:HeroType)
  }

  /**
   * Protobuf enum {@code SkillType}
   *
   * <pre>
   * 技能类型
   * </pre>
   */
  public enum SkillType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>COMMON = 1;</code>
     *
     * <pre>
     * 普通攻击
     * </pre>
     */
    COMMON(0, 1),
    /**
     * <code>EMIT_BUFF = 2;</code>
     *
     * <pre>
     * 只释放BUFF类
     * </pre>
     */
    EMIT_BUFF(1, 2),
    /**
     * <code>FISSURE = 11;</code>
     *
     * <pre>
     * 沟壑
     * </pre>
     */
    FISSURE(2, 11),
    /**
     * <code>ECHO_SLAM = 14;</code>
     *
     * <pre>
     * 回音击
     * </pre>
     */
    ECHO_SLAM(3, 14),
    /**
     * <code>STORM_BOLT = 21;</code>
     *
     * <pre>
     * 风暴之锤
     * </pre>
     */
    STORM_BOLT(4, 21),
    /**
     * <code>SHADOW_RAZE = 31;</code>
     *
     * <pre>
     * 影压(学习3个技能)
     * </pre>
     */
    SHADOW_RAZE(5, 31),
    /**
     * <code>REAL_SHADOW_RAZE = 32;</code>
     *
     * <pre>
     * 真正的影压
     * </pre>
     */
    REAL_SHADOW_RAZE(6, 32),
    /**
     * <code>PRESENSE_OF_THE_DARK_LORD = 34;</code>
     *
     * <pre>
     * 魔王降临
     * </pre>
     */
    PRESENSE_OF_THE_DARK_LORD(7, 34),
    /**
     * <code>REQUIEM_OF_SOULS = 35;</code>
     *
     * <pre>
     * 魂之挽歌
     * </pre>
     */
    REQUIEM_OF_SOULS(8, 35),
    /**
     * <code>MEAT_HOOK = 41;</code>
     *
     * <pre>
     * 肉钩
     * </pre>
     */
    MEAT_HOOK(9, 41),
    /**
     * <code>ROT = 42;</code>
     *
     * <pre>
     * 腐烂
     * </pre>
     */
    ROT(10, 42),
    /**
     * <code>DRAGON_SLAVE = 51;</code>
     *
     * <pre>
     * 龙破斩
     * </pre>
     */
    DRAGON_SLAVE(11, 51),
    /**
     * <code>LIGHT_STRIKE_ARRAY = 52;</code>
     *
     * <pre>
     * 光击阵
     * </pre>
     */
    LIGHT_STRIKE_ARRAY(12, 52),
    /**
     * <code>SKILL_LIKE_LAGUNA_BLADE = 53;</code>
     *
     * <pre>
     * 只对对单体照成伤害的技能	(神灭斩)
     * </pre>
     */
    SKILL_LIKE_LAGUNA_BLADE(13, 53),
    ;

    /**
     * <code>COMMON = 1;</code>
     *
     * <pre>
     * 普通攻击
     * </pre>
     */
    public static final int COMMON_VALUE = 1;
    /**
     * <code>EMIT_BUFF = 2;</code>
     *
     * <pre>
     * 只释放BUFF类
     * </pre>
     */
    public static final int EMIT_BUFF_VALUE = 2;
    /**
     * <code>FISSURE = 11;</code>
     *
     * <pre>
     * 沟壑
     * </pre>
     */
    public static final int FISSURE_VALUE = 11;
    /**
     * <code>ECHO_SLAM = 14;</code>
     *
     * <pre>
     * 回音击
     * </pre>
     */
    public static final int ECHO_SLAM_VALUE = 14;
    /**
     * <code>STORM_BOLT = 21;</code>
     *
     * <pre>
     * 风暴之锤
     * </pre>
     */
    public static final int STORM_BOLT_VALUE = 21;
    /**
     * <code>SHADOW_RAZE = 31;</code>
     *
     * <pre>
     * 影压(学习3个技能)
     * </pre>
     */
    public static final int SHADOW_RAZE_VALUE = 31;
    /**
     * <code>REAL_SHADOW_RAZE = 32;</code>
     *
     * <pre>
     * 真正的影压
     * </pre>
     */
    public static final int REAL_SHADOW_RAZE_VALUE = 32;
    /**
     * <code>PRESENSE_OF_THE_DARK_LORD = 34;</code>
     *
     * <pre>
     * 魔王降临
     * </pre>
     */
    public static final int PRESENSE_OF_THE_DARK_LORD_VALUE = 34;
    /**
     * <code>REQUIEM_OF_SOULS = 35;</code>
     *
     * <pre>
     * 魂之挽歌
     * </pre>
     */
    public static final int REQUIEM_OF_SOULS_VALUE = 35;
    /**
     * <code>MEAT_HOOK = 41;</code>
     *
     * <pre>
     * 肉钩
     * </pre>
     */
    public static final int MEAT_HOOK_VALUE = 41;
    /**
     * <code>ROT = 42;</code>
     *
     * <pre>
     * 腐烂
     * </pre>
     */
    public static final int ROT_VALUE = 42;
    /**
     * <code>DRAGON_SLAVE = 51;</code>
     *
     * <pre>
     * 龙破斩
     * </pre>
     */
    public static final int DRAGON_SLAVE_VALUE = 51;
    /**
     * <code>LIGHT_STRIKE_ARRAY = 52;</code>
     *
     * <pre>
     * 光击阵
     * </pre>
     */
    public static final int LIGHT_STRIKE_ARRAY_VALUE = 52;
    /**
     * <code>SKILL_LIKE_LAGUNA_BLADE = 53;</code>
     *
     * <pre>
     * 只对对单体照成伤害的技能	(神灭斩)
     * </pre>
     */
    public static final int SKILL_LIKE_LAGUNA_BLADE_VALUE = 53;


    public final int getNumber() { return value; }

    public static SkillType valueOf(int value) {
      switch (value) {
        case 1: return COMMON;
        case 2: return EMIT_BUFF;
        case 11: return FISSURE;
        case 14: return ECHO_SLAM;
        case 21: return STORM_BOLT;
        case 31: return SHADOW_RAZE;
        case 32: return REAL_SHADOW_RAZE;
        case 34: return PRESENSE_OF_THE_DARK_LORD;
        case 35: return REQUIEM_OF_SOULS;
        case 41: return MEAT_HOOK;
        case 42: return ROT;
        case 51: return DRAGON_SLAVE;
        case 52: return LIGHT_STRIKE_ARRAY;
        case 53: return SKILL_LIKE_LAGUNA_BLADE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<SkillType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<SkillType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<SkillType>() {
            public SkillType findValueByNumber(int number) {
              return SkillType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dota.enums.Enums.getDescriptor().getEnumTypes().get(3);
    }

    private static final SkillType[] VALUES = values();

    public static SkillType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private SkillType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:SkillType)
  }

  /**
   * Protobuf enum {@code SkillEmitType}
   *
   * <pre>
   * 技能释放类型
   * </pre>
   */
  public enum SkillEmitType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>PASSIVE = 0;</code>
     *
     * <pre>
     * 被动技能
     * </pre>
     */
    PASSIVE(0, 0),
    /**
     * <code>ONETARGET = 1;</code>
     *
     * <pre>
     * 指向型技能
     * </pre>
     */
    ONETARGET(1, 1),
    /**
     * <code>NOTARGET = 2;</code>
     *
     * <pre>
     * 无目标类型
     * </pre>
     */
    NOTARGET(2, 2),
    ;

    /**
     * <code>PASSIVE = 0;</code>
     *
     * <pre>
     * 被动技能
     * </pre>
     */
    public static final int PASSIVE_VALUE = 0;
    /**
     * <code>ONETARGET = 1;</code>
     *
     * <pre>
     * 指向型技能
     * </pre>
     */
    public static final int ONETARGET_VALUE = 1;
    /**
     * <code>NOTARGET = 2;</code>
     *
     * <pre>
     * 无目标类型
     * </pre>
     */
    public static final int NOTARGET_VALUE = 2;


    public final int getNumber() { return value; }

    public static SkillEmitType valueOf(int value) {
      switch (value) {
        case 0: return PASSIVE;
        case 1: return ONETARGET;
        case 2: return NOTARGET;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<SkillEmitType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<SkillEmitType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<SkillEmitType>() {
            public SkillEmitType findValueByNumber(int number) {
              return SkillEmitType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dota.enums.Enums.getDescriptor().getEnumTypes().get(4);
    }

    private static final SkillEmitType[] VALUES = values();

    public static SkillEmitType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private SkillEmitType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:SkillEmitType)
  }

  /**
   * Protobuf enum {@code EmitTargetType}
   *
   * <pre>
   * 技能释放目标类型(当SkillEmitType==1时才有用)
   * </pre>
   */
  public enum EmitTargetType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>ANY = 0;</code>
     *
     * <pre>
     * 任意类型
     * </pre>
     */
    ANY(0, 0),
    /**
     * <code>FRIEND_HERO = 1;</code>
     *
     * <pre>
     * 友方英雄
     * </pre>
     */
    FRIEND_HERO(1, 1),
    /**
     * <code>ENIMY_HERO = 2;</code>
     *
     * <pre>
     * 敌方英雄
     * </pre>
     */
    ENIMY_HERO(2, 2),
    ;

    /**
     * <code>ANY = 0;</code>
     *
     * <pre>
     * 任意类型
     * </pre>
     */
    public static final int ANY_VALUE = 0;
    /**
     * <code>FRIEND_HERO = 1;</code>
     *
     * <pre>
     * 友方英雄
     * </pre>
     */
    public static final int FRIEND_HERO_VALUE = 1;
    /**
     * <code>ENIMY_HERO = 2;</code>
     *
     * <pre>
     * 敌方英雄
     * </pre>
     */
    public static final int ENIMY_HERO_VALUE = 2;


    public final int getNumber() { return value; }

    public static EmitTargetType valueOf(int value) {
      switch (value) {
        case 0: return ANY;
        case 1: return FRIEND_HERO;
        case 2: return ENIMY_HERO;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<EmitTargetType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<EmitTargetType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<EmitTargetType>() {
            public EmitTargetType findValueByNumber(int number) {
              return EmitTargetType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dota.enums.Enums.getDescriptor().getEnumTypes().get(5);
    }

    private static final EmitTargetType[] VALUES = values();

    public static EmitTargetType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private EmitTargetType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:EmitTargetType)
  }

  /**
   * Protobuf enum {@code EffectTargetType}
   *
   * <pre>
   * 作用目标类型 
   * </pre>
   */
  public enum EffectTargetType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>FRIEND = 1;</code>
     */
    FRIEND(0, 1),
    /**
     * <code>ENEMY = 2;</code>
     */
    ENEMY(1, 2),
    ;

    /**
     * <code>FRIEND = 1;</code>
     */
    public static final int FRIEND_VALUE = 1;
    /**
     * <code>ENEMY = 2;</code>
     */
    public static final int ENEMY_VALUE = 2;


    public final int getNumber() { return value; }

    public static EffectTargetType valueOf(int value) {
      switch (value) {
        case 1: return FRIEND;
        case 2: return ENEMY;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<EffectTargetType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<EffectTargetType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<EffectTargetType>() {
            public EffectTargetType findValueByNumber(int number) {
              return EffectTargetType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dota.enums.Enums.getDescriptor().getEnumTypes().get(6);
    }

    private static final EffectTargetType[] VALUES = values();

    public static EffectTargetType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private EffectTargetType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:EffectTargetType)
  }

  /**
   * Protobuf enum {@code BuffType}
   *
   * <pre>
   * BUFF
   * </pre>
   */
  public enum BuffType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>ENCHANT_TOTEM_BUFF = 1;</code>
     *
     * <pre>
     * 类似于强化图腾的BUFF（增加攻击力，受时间和攻击次数限制）
     * </pre>
     */
    ENCHANT_TOTEM_BUFF(0, 1),
    /**
     * <code>AFTER_SHOCK_BUFF = 2;</code>
     *
     * <pre>
     * 类似于余震的BUFF
     * </pre>
     */
    AFTER_SHOCK_BUFF(1, 2),
    /**
     * <code>GREAT_CLEAVE_BUFF = 3;</code>
     *
     * <pre>
     * 溅射
     * </pre>
     */
    GREAT_CLEAVE_BUFF(2, 3),
    /**
     * <code>WAR_CRY_BUFF = 4;</code>
     *
     * <pre>
     * 战吼
     * </pre>
     */
    WAR_CRY_BUFF(3, 4),
    /**
     * <code>NECRO_MASTERY_BUFF = 6;</code>
     *
     * <pre>
     * 死灵支配
     * </pre>
     */
    NECRO_MASTERY_BUFF(4, 6),
    /**
     * <code>AURA_BUFF = 7;</code>
     *
     * <pre>
     * 光环
     * </pre>
     */
    AURA_BUFF(5, 7),
    /**
     * <code>PRESENSE_DARK_LORD_BUFF = 8;</code>
     *
     * <pre>
     * 类似于SF的魔王降临BUFF（降低护甲类）
     * </pre>
     */
    PRESENSE_DARK_LORD_BUFF(6, 8),
    /**
     * <code>SLOW_BUFF = 9;</code>
     *
     * <pre>
     * 减移动速度
     * </pre>
     */
    SLOW_BUFF(7, 9),
    /**
     * <code>ATTACK_REDUCTION_BUFF = 10;</code>
     *
     * <pre>
     * 减攻击力
     * </pre>
     */
    ATTACK_REDUCTION_BUFF(8, 10),
    /**
     * <code>REQUIEM_OF_SOULS_BUFF = 11;</code>
     *
     * <pre>
     * 魂之挽歌，死亡
     * </pre>
     */
    REQUIEM_OF_SOULS_BUFF(9, 11),
    /**
     * <code>ROT_BUFF = 12;</code>
     *
     * <pre>
     * 腐烂
     * </pre>
     */
    ROT_BUFF(10, 12),
    /**
     * <code>FLESH_HEAP = 13;</code>
     *
     * <pre>
     * 堆积腐肉
     * </pre>
     */
    FLESH_HEAP(11, 13),
    /**
     * <code>DISMEMBER_BUFF = 14;</code>
     *
     * <pre>
     * 肢解
     * </pre>
     */
    DISMEMBER_BUFF(12, 14),
    /**
     * <code>FIREY_SOUL = 15;</code>
     *
     * <pre>
     * 炽热之魂
     * </pre>
     */
    FIREY_SOUL(13, 15),
    ;

    /**
     * <code>ENCHANT_TOTEM_BUFF = 1;</code>
     *
     * <pre>
     * 类似于强化图腾的BUFF（增加攻击力，受时间和攻击次数限制）
     * </pre>
     */
    public static final int ENCHANT_TOTEM_BUFF_VALUE = 1;
    /**
     * <code>AFTER_SHOCK_BUFF = 2;</code>
     *
     * <pre>
     * 类似于余震的BUFF
     * </pre>
     */
    public static final int AFTER_SHOCK_BUFF_VALUE = 2;
    /**
     * <code>GREAT_CLEAVE_BUFF = 3;</code>
     *
     * <pre>
     * 溅射
     * </pre>
     */
    public static final int GREAT_CLEAVE_BUFF_VALUE = 3;
    /**
     * <code>WAR_CRY_BUFF = 4;</code>
     *
     * <pre>
     * 战吼
     * </pre>
     */
    public static final int WAR_CRY_BUFF_VALUE = 4;
    /**
     * <code>NECRO_MASTERY_BUFF = 6;</code>
     *
     * <pre>
     * 死灵支配
     * </pre>
     */
    public static final int NECRO_MASTERY_BUFF_VALUE = 6;
    /**
     * <code>AURA_BUFF = 7;</code>
     *
     * <pre>
     * 光环
     * </pre>
     */
    public static final int AURA_BUFF_VALUE = 7;
    /**
     * <code>PRESENSE_DARK_LORD_BUFF = 8;</code>
     *
     * <pre>
     * 类似于SF的魔王降临BUFF（降低护甲类）
     * </pre>
     */
    public static final int PRESENSE_DARK_LORD_BUFF_VALUE = 8;
    /**
     * <code>SLOW_BUFF = 9;</code>
     *
     * <pre>
     * 减移动速度
     * </pre>
     */
    public static final int SLOW_BUFF_VALUE = 9;
    /**
     * <code>ATTACK_REDUCTION_BUFF = 10;</code>
     *
     * <pre>
     * 减攻击力
     * </pre>
     */
    public static final int ATTACK_REDUCTION_BUFF_VALUE = 10;
    /**
     * <code>REQUIEM_OF_SOULS_BUFF = 11;</code>
     *
     * <pre>
     * 魂之挽歌，死亡
     * </pre>
     */
    public static final int REQUIEM_OF_SOULS_BUFF_VALUE = 11;
    /**
     * <code>ROT_BUFF = 12;</code>
     *
     * <pre>
     * 腐烂
     * </pre>
     */
    public static final int ROT_BUFF_VALUE = 12;
    /**
     * <code>FLESH_HEAP = 13;</code>
     *
     * <pre>
     * 堆积腐肉
     * </pre>
     */
    public static final int FLESH_HEAP_VALUE = 13;
    /**
     * <code>DISMEMBER_BUFF = 14;</code>
     *
     * <pre>
     * 肢解
     * </pre>
     */
    public static final int DISMEMBER_BUFF_VALUE = 14;
    /**
     * <code>FIREY_SOUL = 15;</code>
     *
     * <pre>
     * 炽热之魂
     * </pre>
     */
    public static final int FIREY_SOUL_VALUE = 15;


    public final int getNumber() { return value; }

    public static BuffType valueOf(int value) {
      switch (value) {
        case 1: return ENCHANT_TOTEM_BUFF;
        case 2: return AFTER_SHOCK_BUFF;
        case 3: return GREAT_CLEAVE_BUFF;
        case 4: return WAR_CRY_BUFF;
        case 6: return NECRO_MASTERY_BUFF;
        case 7: return AURA_BUFF;
        case 8: return PRESENSE_DARK_LORD_BUFF;
        case 9: return SLOW_BUFF;
        case 10: return ATTACK_REDUCTION_BUFF;
        case 11: return REQUIEM_OF_SOULS_BUFF;
        case 12: return ROT_BUFF;
        case 13: return FLESH_HEAP;
        case 14: return DISMEMBER_BUFF;
        case 15: return FIREY_SOUL;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<BuffType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static com.google.protobuf.Internal.EnumLiteMap<BuffType>
        internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<BuffType>() {
            public BuffType findValueByNumber(int number) {
              return BuffType.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return dota.enums.Enums.getDescriptor().getEnumTypes().get(7);
    }

    private static final BuffType[] VALUES = values();

    public static BuffType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private BuffType(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:BuffType)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021enums/enums.proto*\'\n\nAttackType\022\014\n\010PHY" +
      "SICAL\020\001\022\013\n\007MAGICAL\020\002*6\n\013CombatState\022\010\n\004S" +
      "TUN\020\001\022\014\n\010EMITTINT\020\002\022\017\n\013BE_EMITTING\020\003*7\n\010" +
      "HeroType\022\014\n\010STRENGTH\020\001\022\013\n\007AGILITY\020\002\022\020\n\014I" +
      "NTELLIGENCE\020\003*\215\002\n\tSkillType\022\n\n\006COMMON\020\001\022" +
      "\r\n\tEMIT_BUFF\020\002\022\013\n\007FISSURE\020\013\022\r\n\tECHO_SLAM" +
      "\020\016\022\016\n\nSTORM_BOLT\020\025\022\017\n\013SHADOW_RAZE\020\037\022\024\n\020R" +
      "EAL_SHADOW_RAZE\020 \022\035\n\031PRESENSE_OF_THE_DAR" +
      "K_LORD\020\"\022\024\n\020REQUIEM_OF_SOULS\020#\022\r\n\tMEAT_H" +
      "OOK\020)\022\007\n\003ROT\020*\022\020\n\014DRAGON_SLAVE\0203\022\026\n\022LIGH",
      "T_STRIKE_ARRAY\0204\022\033\n\027SKILL_LIKE_LAGUNA_BL" +
      "ADE\0205*9\n\rSkillEmitType\022\013\n\007PASSIVE\020\000\022\r\n\tO" +
      "NETARGET\020\001\022\014\n\010NOTARGET\020\002*:\n\016EmitTargetTy" +
      "pe\022\007\n\003ANY\020\000\022\017\n\013FRIEND_HERO\020\001\022\016\n\nENIMY_HE" +
      "RO\020\002*)\n\020EffectTargetType\022\n\n\006FRIEND\020\001\022\t\n\005" +
      "ENEMY\020\002*\254\002\n\010BuffType\022\026\n\022ENCHANT_TOTEM_BU" +
      "FF\020\001\022\024\n\020AFTER_SHOCK_BUFF\020\002\022\025\n\021GREAT_CLEA" +
      "VE_BUFF\020\003\022\020\n\014WAR_CRY_BUFF\020\004\022\026\n\022NECRO_MAS" +
      "TERY_BUFF\020\006\022\r\n\tAURA_BUFF\020\007\022\033\n\027PRESENSE_D" +
      "ARK_LORD_BUFF\020\010\022\r\n\tSLOW_BUFF\020\t\022\031\n\025ATTACK",
      "_REDUCTION_BUFF\020\n\022\031\n\025REQUIEM_OF_SOULS_BU" +
      "FF\020\013\022\014\n\010ROT_BUFF\020\014\022\016\n\nFLESH_HEAP\020\r\022\022\n\016DI" +
      "SMEMBER_BUFF\020\016\022\016\n\nFIREY_SOUL\020\017B\014\n\ndota.e" +
      "nums"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
