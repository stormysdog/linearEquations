package net.lax1dude.eaglercraft.v1_8.plugin.bukkit_rpc_helper.impl;

import java.util.concurrent.Executor;

import com.google.common.util.concurrent.MoreExecutors;

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
public class SameThreadExecutor {

	public static final Executor SAME_THREAD_EXECUTOR;
	
	static {
		Executor fuck;
		try {
			fuck = (Executor) MoreExecutors.class.getDeclaredMethod("newDirectExecutorService").invoke(null);
		}catch(Throwable t) {
			try {
				fuck = (Executor) MoreExecutors.class.getDeclaredMethod("sameThreadExecutor").invoke(null);
			}catch(Throwable t2) {
				throw new RuntimeException("Google fucked up!", t2);
			}
		}
		SAME_THREAD_EXECUTOR = fuck;
	}

}
