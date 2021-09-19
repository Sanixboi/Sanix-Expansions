package net.Sanix.Expansions.mixins;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

	@Shadow protected abstract void switchToRealms();

	protected TitleScreenMixin(Text title) {
		super(title);
	}
	
	/**
	 * @author Sanixboi
	 * @reason to change the keys to resource packs and sub to sanixboi (also to remove minecraft realms (useless in snapshots) and readded in full versions)
	 * it used to be overwrite which is why this exists
	 */

	@Inject(at = @At("HEAD"), method = "initWidgetsNormal", cancellable = true)
	private void initWidgetsNormal (int y, int spacingY, CallbackInfo info) {
		assert this.client != null;
		this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, y, 200, 20, new TranslatableText("menu.singleplayer"), (buttonWidget) -> {
	         this.client.openScreen(new SelectWorldScreen(this));
	      }));
	      this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, y + spacingY, 200, 20, new TranslatableText("menu.multiplayer"), (buttonWidget) -> {
	            this.client.openScreen(new MultiplayerScreen(this));
	      }));

		boolean bl = this.client.isMultiplayerEnabled();
		ButtonWidget.TooltipSupplier tooltipSupplier = bl ? ButtonWidget.EMPTY : (buttonWidget, matrixStack, i, j) -> {
			if (!buttonWidget.active) {
				this.renderOrderedTooltip(matrixStack, this.client.textRenderer.wrapLines(new TranslatableText("title.multiplayer.disabled"), Math.max(this.width / 2 - 43, 170)), i, j);
			}

		};

		  this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 4 + 48 + 24 * 2, 98, 20, new TranslatableText("menu.online"), (buttonWidget) -> {
			this.switchToRealms(); }, tooltipSupplier)).active = bl;

		 String string = "https://www.youtube.com/channel/UC8ei-X0EuRI1iGCl2k4x4_Q?sub_confirmation=1";
	     this.addDrawableChild(new ButtonWidget(this.width / 2 + 2, this.height / 4 + 48 + 24 * 2, 98, 20, new TranslatableText("Sub 2 Sanixboi"), (buttonWidgetx) -> {
	               Util.getOperatingSystem().open(string);
	      }));
	     info.cancel();
	}
	
}