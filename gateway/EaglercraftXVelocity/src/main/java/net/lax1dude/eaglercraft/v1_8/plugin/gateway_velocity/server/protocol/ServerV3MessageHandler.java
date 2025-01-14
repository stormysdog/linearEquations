package net.lax1dude.eaglercraft.v1_8.plugin.gateway_velocity.server.protocol;

import java.util.UUID;

import net.lax1dude.eaglercraft.v1_8.plugin.gateway_velocity.EaglerXVelocity;
import net.lax1dude.eaglercraft.v1_8.plugin.gateway_velocity.server.EaglerPlayerData;
import net.lax1dude.eaglercraft.v1_8.plugin.gateway_velocity.voice.VoiceService;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.GameMessageHandler;
import net.lax1dude.eaglercraft.v1_8.socket.protocol.pkt.client.*;

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
public class ServerV3MessageHandler implements GameMessageHandler {

	private final EaglerPlayerData eaglerHandle;
	private final EaglerXVelocity plugin;

	public ServerV3MessageHandler(EaglerPlayerData eaglerHandle, EaglerXVelocity plugin) {
		this.eaglerHandle = eaglerHandle;
		this.plugin = plugin;
	}

	public void handleClient(CPacketGetOtherCapeEAG packet) {
		plugin.getCapeService().processGetOtherCape(new UUID(packet.uuidMost, packet.uuidLeast), eaglerHandle);
	}

	public void handleClient(CPacketGetOtherSkinEAG packet) {
		plugin.getSkinService().processGetOtherSkin(new UUID(packet.uuidMost, packet.uuidLeast), eaglerHandle);
	}

	public void handleClient(CPacketGetSkinByURLEAG packet) {
		plugin.getSkinService().processGetOtherSkin(new UUID(packet.uuidMost, packet.uuidLeast), packet.url, eaglerHandle);
	}

	public void handleClient(CPacketVoiceSignalConnectEAG packet) {
		VoiceService svc = plugin.getVoiceService();
		if(svc != null && eaglerHandle.getEaglerListenerConfig().getEnableVoiceChat()) {
			svc.handleVoiceSignalPacketTypeConnect(eaglerHandle);
		}
	}

	public void handleClient(CPacketVoiceSignalDescEAG packet) {
		VoiceService svc = plugin.getVoiceService();
		if(svc != null && eaglerHandle.getEaglerListenerConfig().getEnableVoiceChat()) {
			svc.handleVoiceSignalPacketTypeDesc(new UUID(packet.uuidMost, packet.uuidLeast), packet.desc, eaglerHandle);
		}
	}

	public void handleClient(CPacketVoiceSignalDisconnectV3EAG packet) {
		VoiceService svc = plugin.getVoiceService();
		if(svc != null && eaglerHandle.getEaglerListenerConfig().getEnableVoiceChat()) {
			if(packet.isPeerType) {
				svc.handleVoiceSignalPacketTypeDisconnectPeer(new UUID(packet.uuidMost, packet.uuidLeast), eaglerHandle);
			}else {
				svc.handleVoiceSignalPacketTypeDisconnect(eaglerHandle);
			}
		}
	}

	public void handleClient(CPacketVoiceSignalICEEAG packet) {
		VoiceService svc = plugin.getVoiceService();
		if(svc != null && eaglerHandle.getEaglerListenerConfig().getEnableVoiceChat()) {
			svc.handleVoiceSignalPacketTypeICE(new UUID(packet.uuidMost, packet.uuidLeast), packet.ice, eaglerHandle);
		}
	}

	public void handleClient(CPacketVoiceSignalRequestEAG packet) {
		VoiceService svc = plugin.getVoiceService();
		if(svc != null && eaglerHandle.getEaglerListenerConfig().getEnableVoiceChat()) {
			svc.handleVoiceSignalPacketTypeRequest(new UUID(packet.uuidMost, packet.uuidLeast), eaglerHandle);
		}
	}

}
