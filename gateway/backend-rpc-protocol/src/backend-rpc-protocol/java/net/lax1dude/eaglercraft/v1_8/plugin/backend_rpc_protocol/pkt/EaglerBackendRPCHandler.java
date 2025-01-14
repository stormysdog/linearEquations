package net.lax1dude.eaglercraft.v1_8.plugin.backend_rpc_protocol.pkt;

import net.lax1dude.eaglercraft.v1_8.plugin.backend_rpc_protocol.pkt.client.*;
import net.lax1dude.eaglercraft.v1_8.plugin.backend_rpc_protocol.pkt.server.*;

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
public interface EaglerBackendRPCHandler {

	default void handleClient(CPacketRPCEnabled packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCRequestPlayerInfo packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCSubscribeEvents packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCSetPlayerSkin packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCSetPlayerCape packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCSetPlayerCookie packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCSetPlayerFNAWEn packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCRedirectPlayer packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCResetPlayerMulti packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCSendWebViewMessage packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCSetPauseMenuCustom packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCNotifIconRegister packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCNotifIconRelease packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCNotifBadgeShow packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCNotifBadgeHide packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCDisabled packet) {
		throw new WrongRPCPacketException();
	}

	default void handleClient(CPacketRPCSendRawMessage packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCEnabledSuccess packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCEnabledFailure packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCResponseTypeNull packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCResponseTypeBytes packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCResponseTypeString packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCResponseTypeUUID packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCResponseTypeCookie packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCResponseTypeVoiceStatus packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCResponseTypeWebViewStatus packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCResponseTypeError packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCEventWebViewOpenClose packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCEventWebViewMessage packet) {
		throw new WrongRPCPacketException();
	}

	default void handleServer(SPacketRPCEventToggledVoice packet) {
		throw new WrongRPCPacketException();
	}

}
