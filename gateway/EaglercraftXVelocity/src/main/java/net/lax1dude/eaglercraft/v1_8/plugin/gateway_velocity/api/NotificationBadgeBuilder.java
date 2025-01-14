package net.lax1dude.eaglercraft.v1_8.plugin.gateway_velocity.api;

import java.util.UUID;

import net.kyori.adventure.text.Component;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketNotifBadgeShowV4EAG;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.server.SPacketNotifBadgeShowV4EAG.EnumBadgePriority;

/**
 * Copyright (c) 2024 lax1dude. All Rights Reserved.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 */
public class NotificationBadgeBuilder {

	public static enum BadgePriority {
		LOW, NORMAL, HIGHER, HIGHEST;
	}

	private UUID badgeUUID = null;
	private Component bodyComponent = null;
	private Component titleComponent = null;
	private Component sourceComponent = null;
	private long originalTimestampSec = 0l;
	private boolean silent = false;
	private BadgePriority priority = BadgePriority.NORMAL;
	private UUID mainIconUUID = null;
	private UUID titleIconUUID = null;
	private int hideAfterSec = 10;
	private int expireAfterSec = 3600;
	private int backgroundColor = 0xFFFFFF;
	private int bodyTxtColor = 0xFFFFFF;
	private int titleTxtColor = 0xFFFFFF;
	private int sourceTxtColor = 0xFFFFFF;

	private SPacketNotifBadgeShowV4EAG packetCache = null;
	private boolean packetDirty = true;

	public NotificationBadgeBuilder() {
		originalTimestampSec = System.currentTimeMillis() / 1000l;
	}

	public NotificationBadgeBuilder(NotificationBadgeBuilder builder) {
		badgeUUID = builder.badgeUUID;
		bodyComponent = builder.bodyComponent;
		titleComponent = builder.titleComponent;
		sourceComponent = builder.sourceComponent;
		originalTimestampSec = builder.originalTimestampSec;
		silent = builder.silent;
		priority = builder.priority;
		mainIconUUID = builder.mainIconUUID;
		titleIconUUID = builder.titleIconUUID;
		hideAfterSec = builder.hideAfterSec;
		backgroundColor = builder.backgroundColor;
		bodyTxtColor = builder.bodyTxtColor;
		titleTxtColor = builder.titleTxtColor;
		sourceTxtColor = builder.sourceTxtColor;
		packetCache = !builder.packetDirty ? builder.packetCache : null;
		packetDirty = builder.packetDirty;
	}

	public NotificationBadgeBuilder(SPacketNotifBadgeShowV4EAG packet) {
		badgeUUID = new UUID(packet.badgeUUIDMost, packet.badgeUUIDLeast);
		try {
			bodyComponent = JSONLegacySerializer.instance.deserialize(packet.bodyComponent);
		}catch(Throwable t) {
			bodyComponent = Component.text(packet.bodyComponent);
		}
		try {
			titleComponent = JSONLegacySerializer.instance.deserialize(packet.titleComponent);
		}catch(Throwable t) {
			titleComponent = Component.text(packet.titleComponent);
		}
		try {
			sourceComponent = JSONLegacySerializer.instance.deserialize(packet.sourceComponent);
		}catch(Throwable t) {
			sourceComponent = Component.text(packet.sourceComponent);
		}
		originalTimestampSec = packet.originalTimestampSec;
		silent = packet.silent;
		switch(packet.priority) {
		case LOW:
		default:
			priority = BadgePriority.LOW;
			break;
		case NORMAL:
			priority = BadgePriority.NORMAL;
			break;
		case HIGHER:
			priority = BadgePriority.HIGHER;
			break;
		case HIGHEST:
			priority = BadgePriority.HIGHEST;
			break;
		}
		mainIconUUID = new UUID(packet.mainIconUUIDMost, packet.mainIconUUIDLeast);
		titleIconUUID = new UUID(packet.titleIconUUIDMost, packet.titleIconUUIDLeast);
		hideAfterSec = packet.hideAfterSec;
		backgroundColor = packet.backgroundColor;
		bodyTxtColor = packet.bodyTxtColor;
		titleTxtColor = packet.titleTxtColor;
		sourceTxtColor = packet.sourceTxtColor;
		packetCache = packet;
		packetDirty = false;
	}

	public UUID getBadgeUUID() {
		return badgeUUID;
	}

	public NotificationBadgeBuilder setBadgeUUID(UUID badgeUUID) {
		this.badgeUUID = badgeUUID;
		this.packetDirty = true;
		return this;
	}

	public NotificationBadgeBuilder setBadgeUUIDRandom() {
		this.badgeUUID = UUID.randomUUID();
		this.packetDirty = true;
		return this;
	}

	public Component getBodyComponent() {
		return bodyComponent;
	}

	public NotificationBadgeBuilder setBodyComponent(Component bodyComponent) {
		this.bodyComponent = bodyComponent;
		this.packetDirty = true;
		return this;
	}

	public NotificationBadgeBuilder setBodyComponent(String bodyText) {
		this.bodyComponent = Component.text(bodyText);
		this.packetDirty = true;
		return this;
	}

	public Component getTitleComponent() {
		return titleComponent;
	}

	public NotificationBadgeBuilder setTitleComponent(Component titleComponent) {
		this.titleComponent = titleComponent;
		this.packetDirty = true;
		return this;
	}

	public NotificationBadgeBuilder setTitleComponent(String titleText) {
		this.titleComponent = Component.text(titleText);
		this.packetDirty = true;
		return this;
	}

	public Component getSourceComponent() {
		return sourceComponent;
	}

	public NotificationBadgeBuilder setSourceComponent(Component sourceComponent) {
		this.sourceComponent = sourceComponent;
		this.packetDirty = true;
		return this;
	}

	public NotificationBadgeBuilder setSourceComponent(String sourceText) {
		this.sourceComponent = Component.text(sourceText);
		this.packetDirty = true;
		return this;
	}

	public long getOriginalTimestampSec() {
		return originalTimestampSec;
	}

	public NotificationBadgeBuilder setOriginalTimestampSec(long originalTimestampSec) {
		this.originalTimestampSec = originalTimestampSec;
		this.packetDirty = true;
		return this;
	}

	public boolean isSilent() {
		return silent;
	}

	public NotificationBadgeBuilder setSilent(boolean silent) {
		this.silent = silent;
		this.packetDirty = true;
		return this;
	}

	public BadgePriority getPriority() {
		return priority;
	}

	public NotificationBadgeBuilder setPriority(BadgePriority priority) {
		this.priority = priority;
		this.packetDirty = true;
		return this;
	}

	public UUID getMainIconUUID() {
		return mainIconUUID;
	}

	public NotificationBadgeBuilder setMainIconUUID(UUID mainIconUUID) {
		this.mainIconUUID = mainIconUUID;
		this.packetDirty = true;
		return this;
	}

	public UUID getTitleIconUUID() {
		return titleIconUUID;
	}

	public NotificationBadgeBuilder setTitleIconUUID(UUID titleIconUUID) {
		this.titleIconUUID = titleIconUUID;
		this.packetDirty = true;
		return this;
	}

	public int getHideAfterSec() {
		return hideAfterSec;
	}

	public NotificationBadgeBuilder setHideAfterSec(int hideAfterSec) {
		this.hideAfterSec = hideAfterSec;
		this.packetDirty = true;
		return this;
	}

	public int getExpireAfterSec() {
		return expireAfterSec;
	}

	public NotificationBadgeBuilder setExpireAfterSec(int expireAfterSec) {
		this.expireAfterSec = expireAfterSec;
		this.packetDirty = true;
		return this;
	}

	public int getBackgroundColor() {
		return backgroundColor;
	}

	public NotificationBadgeBuilder setBackgroundColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
		this.packetDirty = true;
		return this;
	}

	public int getBodyTxtColorRGB() {
		return bodyTxtColor;
	}

	public NotificationBadgeBuilder setBodyTxtColorRGB(int colorRGB) {
		this.bodyTxtColor = colorRGB;
		this.packetDirty = true;
		return this;
	}

	public NotificationBadgeBuilder setBodyTxtColorRGB(int colorR, int colorG, int colorB) {
		this.bodyTxtColor = (colorR << 16) | (colorG << 8) | colorB;
		this.packetDirty = true;
		return this;
	}

	public int getTitleTxtColorRGB() {
		return titleTxtColor;
	}

	public NotificationBadgeBuilder setTitleTxtColorRGB(int colorRGB) {
		this.titleTxtColor = colorRGB;
		this.packetDirty = true;
		return this;
	}

	public NotificationBadgeBuilder setTitleTxtColorRGB(int colorR, int colorG, int colorB) {
		this.titleTxtColor = (colorR << 16) | (colorG << 8) | colorB;
		this.packetDirty = true;
		return this;
	}

	public int getSourceTxtColorRGB() {
		return sourceTxtColor;
	}

	public NotificationBadgeBuilder setSourceTxtColorRGB(int colorRGB) {
		this.sourceTxtColor = colorRGB;
		this.packetDirty = true;
		return this;
	}

	public NotificationBadgeBuilder setSourceTxtColorRGB(int colorR, int colorG, int colorB) {
		this.sourceTxtColor = (colorR << 16) | (colorG << 8) | colorB;
		this.packetDirty = true;
		return this;
	}

	public Object clone() {
		return new NotificationBadgeBuilder(this);
	}

	public SPacketNotifBadgeShowV4EAG buildPacket() {
		if(packetDirty || packetCache == null) {
			if(badgeUUID == null) {
				badgeUUID = UUID.randomUUID();
			}else if(badgeUUID.getMostSignificantBits() == 0l && badgeUUID.getLeastSignificantBits() == 0l) {
				throw new IllegalStateException("Badge UUID cannot be 0!");
			}
			EnumBadgePriority internalPriority;
			switch(priority) {
			case LOW:
			default:
				internalPriority = EnumBadgePriority.LOW;
				break;
			case NORMAL:
				internalPriority = EnumBadgePriority.NORMAL;
				break;
			case HIGHER:
				internalPriority = EnumBadgePriority.HIGHER;
				break;
			case HIGHEST:
				internalPriority = EnumBadgePriority.HIGHEST;
				break;
			}
			String bodyComp = bodyComponent != null ? JSONLegacySerializer.instance.serialize(bodyComponent) : "";
			if(bodyComp.length() > 32767) {
				throw new IllegalStateException("Body component is longer than 32767 chars serialized!");
			}
			String titleComp = titleComponent != null ? JSONLegacySerializer.instance.serialize(titleComponent) : "";
			if(titleComp.length() > 255) {
				throw new IllegalStateException("Title component is longer than 255 chars serialized!");
			}
			String sourceComp = sourceComponent != null ? JSONLegacySerializer.instance.serialize(sourceComponent) : "";
			if(sourceComp.length() > 255) {
				throw new IllegalStateException("Body component is longer than 255 chars serialized!");
			}
			packetCache = new SPacketNotifBadgeShowV4EAG(badgeUUID.getMostSignificantBits(),
					badgeUUID.getLeastSignificantBits(), bodyComp, titleComp, sourceComp, originalTimestampSec, silent,
					internalPriority, mainIconUUID != null ? mainIconUUID.getMostSignificantBits() : 0l,
					mainIconUUID != null ? mainIconUUID.getLeastSignificantBits() : 0l,
					titleIconUUID != null ? titleIconUUID.getMostSignificantBits() : 0l,
					titleIconUUID != null ? titleIconUUID.getLeastSignificantBits() : 0l, hideAfterSec, expireAfterSec,
					backgroundColor, bodyTxtColor, titleTxtColor, sourceTxtColor);
			packetDirty = false;
		}
		return packetCache;
	}

}
