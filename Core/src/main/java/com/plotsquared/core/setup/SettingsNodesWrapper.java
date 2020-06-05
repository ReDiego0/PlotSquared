package com.plotsquared.core.setup;

import com.plotsquared.core.configuration.ConfigurationNode;
import lombok.Getter;

/**
 * This class wraps an array of {@link ConfigurationNode}s.
 */
public class SettingsNodesWrapper {
    @Getter private final ConfigurationNode[] settingsNodes;
    @Getter private final SetupStep afterwards;

    public SettingsNodesWrapper(ConfigurationNode[] settingsNodes, SetupStep afterwards) {
        this.settingsNodes = settingsNodes;
        this.afterwards = afterwards;
    }

    /**
     * Returns the first step of this wrapper or the step or the
     * {@code afterwards} step if no step is available.
     *
     * @return the first step or {@code afterwards}.
     */
    public SetupStep getFirstStep() {
        return this.settingsNodes.length == 0 ? this.afterwards : new SettingsNodeStep(this.settingsNodes[0], 0, this);
    }
}
