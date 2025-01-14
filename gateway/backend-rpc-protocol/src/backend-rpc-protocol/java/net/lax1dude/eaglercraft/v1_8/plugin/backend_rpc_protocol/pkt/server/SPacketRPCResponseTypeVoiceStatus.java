package net.lax1dude.eaglercraft.v1_8.plugin.backend_rpc_protocol.pkt.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.lax1dude.eaglercraft.v1_8.plugin.backend_rpc_protocol.pkt.EaglerBackendRPCHandler;
import net.lax1dude.eaglercraft.v1_8.plugin.backend_rpc_protocol.pkt.EaglerBackendRPCPacket;

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
public class SPacketRPCResponseTypeVoiceStatus implements EaglerBackendRPCPacket {

	public static final int VOICE_STATE_SERVER_DISABLE = 0;
	public static final int VOICE_STATE_DISABLED = 1;
	public static final int VOICE_STATE_ENABLED = 2;

	public int requestID;
	public int voiceState;

	public SPacketRPCResponseTypeVoiceStatus() {
	}

	public SPacketRPCResponseTypeVoiceStatus(int requestID, int voiceState) {
		this.requestID = requestID;
		this.voiceState = voiceState;
	}

	@Override
	public void readPacket(DataInput buffer) throws IOException {
		requestID = buffer.readInt();
		voiceState = buffer.readUnsignedByte();
	}

	@Override
	public void writePacket(DataOutput buffer) throws IOException {
		buffer.writeInt(requestID);
		buffer.writeByte(voiceState);
	}

	@Override
	public void handlePacket(EaglerBackendRPCHandler handler) {
		handler.handleServer(this);
	}

	@Override
	public int length() {
		return 5;
	}

}
