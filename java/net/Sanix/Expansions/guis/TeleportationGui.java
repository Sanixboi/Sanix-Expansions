package net.Sanix.Expansions.guis;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.Sanix.Expansions.SanixExpansions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

import java.util.Objects;

public class TeleportationGui extends SyncedGuiDescription {
    public TeleportationGui(int syncId, PlayerInventory playerInventory, PlayerEntity user) {
        super(SanixExpansions.TELEPORTATION_SCREEN_HANDLER, syncId, playerInventory);
        NbtCompound tpn = user.getActiveItem().getOrCreateSubTag("teleportation"); // not tpm lol but teleportation nbt (tpn)
        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);
        root.setSize(256, 240);
        root.setInsets(Insets.ROOT_PANEL);
        WButton resetlocation = new WButton(new LiteralText("reset"));
        resetlocation.setOnClick(() -> {
            for (int i = 0; i < 5; i++) {
                tpn.putDouble("x" + i, 0);
                tpn.putInt("y" + i, 0);
                tpn.putInt("z" + i, 0);
                tpn.putInt("dim" + i, 0); // 0 is overworld; 1 is nether; 2 is end;
                tpn.putInt("home" + i, 0); //is it
            }
        });
        WLabel h0 = new WLabel(new TranslatableText("Home 1"));
        WLabel h1 = new WLabel(new TranslatableText("Home 2"));
        WLabel h2 = new WLabel(new TranslatableText("Home 3"));
        WLabel h3 = new WLabel(new TranslatableText("Home 4"));
        WLabel h4 = new WLabel(new TranslatableText("Home 5"));

        WButton tph0 = new WButton(tpn.getInt("home0") == 0 ? new LiteralText("Sethome"): new LiteralText("Teleport"));
        WButton tph1 = new WButton(tpn.getInt("home1") == 0 ? new LiteralText("Sethome"): new LiteralText("Teleport"));
        WButton tph2 = new WButton(tpn.getInt("home2") == 0 ? new LiteralText("Sethome"): new LiteralText("Teleport"));
        WButton tph3 = new WButton(tpn.getInt("home3") == 0 ? new LiteralText("Sethome"): new LiteralText("Teleport"));
        WButton tph4 = new WButton(tpn.getInt("home4") == 0 ? new LiteralText("Sethome"): new LiteralText("Teleport"));

        tph0.setOnClick(() -> {
            if (tpn.getInt("home0") == 0) {
                tpn.putDouble("x0", user.getX());
                tpn.putDouble("y0", user.getY());
                tpn.putDouble("z0", user.getZ());
                tpn.putFloat("yaw0", user.getYaw());
                tpn.putFloat("p0", user.getPitch());
                tpn.putInt("home0", 1);

                if (user.getEntityWorld().getDimension().isBedWorking()) {
                    tpn.putInt("dim0", 0);
                } else if (user.getEntityWorld().getDimension().isRespawnAnchorWorking()) {
                    tpn.putInt("dim0", 1);
                } else {
                    tpn.putInt("dim0", 2);
                }
            } else {
                RegistryKey<World> key = switch (tpn.getInt("dim0")) {
                    case 0 -> World.OVERWORLD;
                    case 1 -> World.NETHER;
                    case 2 -> World.END;
                    default -> throw new IllegalStateException("Unexpected value: " + tpn.getInt("dim0"));
                };
                if (!user.getEntityWorld().isClient) {
                    ServerWorld serverworld = Objects.requireNonNull(user.getEntityWorld().getServer()).getWorld(key);

                    ((ServerPlayerEntity) user).teleport(serverworld, tpn.getDouble("x0"), tpn.getDouble("y0"), tpn.getDouble("z0"), user.getYaw(), user.getPitch());
                    user.getEntityWorld().sendEntityStatus(user, (byte) 46);
                }
            }
        });

        tph1.setOnClick(() -> {
            if (tpn.getInt("home1") == 0) {
                tpn.putDouble("x1", user.getX());
                tpn.putDouble("y1", user.getY());
                tpn.putDouble("z1", user.getZ());
                tpn.putFloat("yaw1", user.getYaw());
                tpn.putFloat("p1", user.getPitch());
                tpn.putInt("home1", 1);

                if (user.getEntityWorld().getDimension().isBedWorking()) {
                    tpn.putInt("dim1", 0);
                } else if (user.getEntityWorld().getDimension().isRespawnAnchorWorking()) {
                    tpn.putInt("dim1", 1);
                } else {
                    tpn.putInt("dim1", 2);
                }
            } else {
                RegistryKey<World> key = switch (tpn.getInt("dim1")) {
                    case 0 -> World.OVERWORLD;
                    case 1 -> World.NETHER;
                    case 2 -> World.END;
                    default -> throw new IllegalStateException("Unexpected value: " + tpn.getInt("dim1"));
                };
                if (!user.getEntityWorld().isClient) {
                    ServerWorld serverworld = Objects.requireNonNull(user.getEntityWorld().getServer()).getWorld(key);

                    ((ServerPlayerEntity) user).teleport(serverworld, tpn.getDouble("x1"), tpn.getDouble("y1"), tpn.getDouble("z1"), user.getYaw(), user.getPitch());
                    user.getEntityWorld().sendEntityStatus(user, (byte) 46);
                }
            }
        });

        tph0.setOnClick(() -> {
            if (tpn.getInt("home2") == 0) {
                tpn.putDouble("x2", user.getX());
                tpn.putDouble("y2", user.getY());
                tpn.putDouble("z2", user.getZ());
                tpn.putFloat("yaw2", user.getYaw());
                tpn.putFloat("p2", user.getPitch());
                tpn.putInt("home2", 1);

                if (user.getEntityWorld().getDimension().isBedWorking()) {
                    tpn.putInt("dim2", 0);
                } else if (user.getEntityWorld().getDimension().isRespawnAnchorWorking()) {
                    tpn.putInt("dim2", 1);
                } else {
                    tpn.putInt("dim2", 2);
                }
            } else {
                RegistryKey<World> key = switch (tpn.getInt("dim2")) {
                    case 0 -> World.OVERWORLD;
                    case 1 -> World.NETHER;
                    case 2 -> World.END;
                    default -> throw new IllegalStateException("Unexpected value: " + tpn.getInt("dim2"));
                };
                if (!user.getEntityWorld().isClient) {
                    ServerWorld serverworld = Objects.requireNonNull(user.getEntityWorld().getServer()).getWorld(key);

                    ((ServerPlayerEntity) user).teleport(serverworld, tpn.getDouble("x2"), tpn.getDouble("y2"), tpn.getDouble("z2"), user.getYaw(), user.getPitch());
                    user.getEntityWorld().sendEntityStatus(user, (byte) 46);
                }
            }
        });

        tph0.setOnClick(() -> {
            if (tpn.getInt("home3") == 0) {
                tpn.putDouble("x3", user.getX());
                tpn.putDouble("y3", user.getY());
                tpn.putDouble("z3", user.getZ());
                tpn.putFloat("yaw3", user.getYaw());
                tpn.putFloat("p3", user.getPitch());
                tpn.putInt("home3", 1);

                if (user.getEntityWorld().getDimension().isBedWorking()) {
                    tpn.putInt("dim3", 0);
                } else if (user.getEntityWorld().getDimension().isRespawnAnchorWorking()) {
                    tpn.putInt("dim3", 1);
                } else {
                    tpn.putInt("dim3", 2);
                }
            } else {
                RegistryKey<World> key = switch (tpn.getInt("dim3")) {
                    case 0 -> World.OVERWORLD;
                    case 1 -> World.NETHER;
                    case 2 -> World.END;
                    default -> throw new IllegalStateException("Unexpected value: " + tpn.getInt("dim3"));
                };
                if (!user.getEntityWorld().isClient) {
                    ServerWorld serverworld = Objects.requireNonNull(user.getEntityWorld().getServer()).getWorld(key);

                    ((ServerPlayerEntity) user).teleport(serverworld, tpn.getDouble("x3"), tpn.getDouble("y3"), tpn.getDouble("z3"), user.getYaw(), user.getPitch());
                    user.getEntityWorld().sendEntityStatus(user, (byte) 46);
                }
            }
        });

        tph0.setOnClick(() -> {
            if (tpn.getInt("home4") == 0) {
                tpn.putDouble("x4", user.getX());
                tpn.putDouble("y4", user.getY());
                tpn.putDouble("z4", user.getZ());
                tpn.putFloat("yaw4", user.getYaw());
                tpn.putFloat("p4", user.getPitch());
                tpn.putInt("home4", 1);

                if (user.getEntityWorld().getDimension().isBedWorking()) {
                    tpn.putInt("dim4", 0);
                } else if (user.getEntityWorld().getDimension().isRespawnAnchorWorking()) {
                    tpn.putInt("dim4", 1);
                } else {
                    tpn.putInt("dim4", 2);
                }
            } else {
                RegistryKey<World> key = switch (tpn.getInt("dim4")) {
                    case 0 -> World.OVERWORLD;
                    case 1 -> World.NETHER;
                    case 2 -> World.END;
                    default -> throw new IllegalStateException("Unexpected value: " + tpn.getInt("dim4"));
                };
                if (!user.getEntityWorld().isClient) {
                    ServerWorld serverworld = Objects.requireNonNull(user.getEntityWorld().getServer()).getWorld(key);

                    ((ServerPlayerEntity) user).teleport(serverworld, tpn.getDouble("x4"), tpn.getDouble("y4"), tpn.getDouble("z4"), user.getYaw(), user.getPitch());
                    user.getEntityWorld().sendEntityStatus(user, (byte) 46);
                }
            }
        });

        WLabel label = new WLabel(new TranslatableText("Teleportation Rune"));
        root.add(label, 1, 0, 4, 1);
        root.add(h0, 0, 25, 4, 1);
        root.add(h1, 0, 50, 4, 1);
        root.add(h2, 0, 75, 4, 1);
        root.add(h3, 0, 100, 4, 1);
        root.add(h4, 0, 125, 4, 1);
        root.add(tph0, 40, 20, 50, 50);
        root.add(tph1, 40, 45, 50, 50);
        root.add(tph2, 40, 70, 50, 50);
        root.add(tph3, 40, 95, 50, 50);
        root.add(tph4, 40, 120, 50, 50);
        root.add(resetlocation, 100, 50, 50, 100);

        root.validate(this);
    }

    /*
    public TeleportationGui(PlayerEntity user) {


    }
     */

}
