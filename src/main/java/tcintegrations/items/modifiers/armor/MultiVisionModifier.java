package tcintegrations.items.modifiers.armor;

import java.util.List;

import slimeknights.mantle.data.registry.GenericLoaderRegistry;

import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHook;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.RawDataModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.utils.RestrictedCompoundTag;

public enum MultiVisionModifier implements ModifierModule, RawDataModifierHook {
    INSTANCE;

    private static final List<ModifierHook<?>> DEFAULT_HOOKS = ModifierModule.<MultiVisionModifier>defaultHooks(TinkerHooks.RAW_DATA);
    public static final GenericLoaderRegistry.IGenericLoader<MultiVisionModifier> LOADER = new GenericLoaderRegistry.SingletonLoader<>(INSTANCE);
    public static final String VOLTMETER = "ie_voltmeter";

    @Override
    public void addRawData(IToolStackView tool, ModifierEntry modifier, RestrictedCompoundTag tag) {
        if (tool.hasTag(TinkerTags.Items.HELMETS)) {
            tag.putBoolean(VOLTMETER, true);
        }
    }

    @Override
    public List<ModifierHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    @Override
    public void removeRawData(IToolStackView tool, Modifier modifier, RestrictedCompoundTag tag) {
        tag.remove(VOLTMETER);
    }

    @Override
    public GenericLoaderRegistry.IGenericLoader<? extends ModifierModule> getLoader() {
        return LOADER;
    }

}
