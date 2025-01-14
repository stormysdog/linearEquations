package net.lax1dude.eaglercraft.v1_8.internal.teavm;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;
import org.teavm.jso.dom.events.Event;

import net.lax1dude.eaglercraft.v1_8.log4j.LogManager;
import net.lax1dude.eaglercraft.v1_8.log4j.Logger;

/**
 * Copyright (c) 2023-2024 lax1dude, ayunami2000. All Rights Reserved.
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
public class FixWebMDurationJS {

	private static final Logger logger = LogManager.getLogger("FixWebMDurationJS");

	private static JSObject fixWebMDurationHandle = null;

	@JSBody(params = {}, script = "return typeof window.ysFixWebmDuration !== \"undefined\"")
	private static native boolean isOldScriptStillLoaded();

	public static void checkOldScriptStillLoaded() {
		if(isOldScriptStillLoaded()) {
			logger.error("The \"fix-webm-duration.js\" script is no longer required for EaglercraftX 1.8 u20 and up, it can be safely removed from this page");
		}
	}

	public static void getRecUrl(Event e, int duration, RecUrlHandler cb, LogMsgHandler logger) {
		checkOldScriptStillLoaded();
		if(fixWebMDurationHandle == null) {
			fixWebMDurationHandle = register();
		}
		getRecUrlImpl(fixWebMDurationHandle, e, duration, cb, logger);
	}

	@JSFunctor
	public static interface RecUrlHandler extends JSObject {
		void onUrl(String url);
	}

	@JSFunctor
	public static interface LogMsgHandler extends JSObject {
		void onMsg(String url);
	}

	@JSBody(params = { "lib", "e", "duration", "cb", "lgg" }, script = "lib(e.data, duration, function(b) { cb(URL.createObjectURL(b)); }, { logger: lgg });")
	private static native void getRecUrlImpl(JSObject lib, Event e, int duration, RecUrlHandler cb, LogMsgHandler logger);

	/*
	 * The MIT license (for fix-webm-duration)
	 * 
	 * Copyright (c) 2018 Yury Sitnikov
	 * 
	 * Permission is hereby granted, free of charge, to any person obtaining a copy
	 * of this software and associated documentation files (the "Software"), to deal
	 * in the Software without restriction, including without limitation the rights
	 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	 * copies of the Software, and to permit persons to whom the Software is
	 * furnished to do so, subject to the following conditions:
	 * 
	 * The above copyright notice and this permission notice shall be included in
	 * all copies or substantial portions of the Software.
	 * 
	 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	 * THE SOFTWARE.
	 */

	@JSBody(params = {}, script = "var m=function(a,b){a.prototype=Object.create(b.prototype);a.prototype.constructor=a};var e=function(a,b){this.name=a||\"Unknown\";this.type=b||\"Unknown\"};var l=function(a,b){e.call(this,a,b||\"Uint\")};var k=function(a,b){e.call(this,a,b||\"Float\")};var h=function(a,b){e.call(this,a,b||\"Container\")};var n=function(a){h.call(this,\"File\",\"File\");"
			+ "this.setSource(a)};var p=function(a,b,c,d){\"object\"===typeof c&&(d=c,c=void 0);if(!c)return new Promise(function(g){p(a,b,g,d)});try{var f=new FileReader;f.onloadend=function(){try{var g=new n(new Uint8Array(f.result));g.fixDuration(b,d)&&(a=g.toBlob(a.type))}catch(q){}c(a)};f.readAsArrayBuffer(a)}catch(g){c(a)}};var r={172351395:{name:\"EBML\",type:\"Container\"},646:{name:\"EBMLVersion\",type:\"Uint\"},759:{name:\"EBMLReadVersion\",type:\"Uint\"},754:{name:\"EBMLMaxIDLength\",type:\"Uint\"},755:{name:\"EBMLMaxSizeLength\","
			+ "type:\"Uint\"},642:{name:\"DocType\",type:\"String\"},647:{name:\"DocTypeVersion\",type:\"Uint\"},645:{name:\"DocTypeReadVersion\",type:\"Uint\"},108:{name:\"Void\",type:\"Binary\"},63:{name:\"CRC-32\",type:\"Binary\"},190023271:{name:\"SignatureSlot\",type:\"Container\"},16010:{name:\"SignatureAlgo\",type:\"Uint\"},16026:{name:\"SignatureHash\",type:\"Uint\"},16037:{name:\"SignaturePublicKey\",type:\"Binary\"},16053:{name:\"Signature\",type:\"Binary\"},15963:{name:\"SignatureElements\",type:\"Container\"},15995:{name:\"SignatureElementList\","
			+ "type:\"Container\"},9522:{name:\"SignedElement\",type:\"Binary\"},139690087:{name:\"Segment\",type:\"Container\"},21863284:{name:\"SeekHead\",type:\"Container\"},3515:{name:\"Seek\",type:\"Container\"},5035:{name:\"SeekID\",type:\"Binary\"},5036:{name:\"SeekPosition\",type:\"Uint\"},88713574:{name:\"Info\",type:\"Container\"},13220:{name:\"SegmentUID\",type:\"Binary\"},13188:{name:\"SegmentFilename\",type:\"String\"},1882403:{name:\"PrevUID\",type:\"Binary\"},1868715:{name:\"PrevFilename\",type:\"String\"},2013475:{name:\"NextUID\",type:\"Binary\"},"
			+ "1999803:{name:\"NextFilename\",type:\"String\"},1092:{name:\"SegmentFamily\",type:\"Binary\"},10532:{name:\"ChapterTranslate\",type:\"Container\"},10748:{name:\"ChapterTranslateEditionUID\",type:\"Uint\"},10687:{name:\"ChapterTranslateCodec\",type:\"Uint\"},10661:{name:\"ChapterTranslateID\",type:\"Binary\"},710577:{name:\"TimecodeScale\",type:\"Uint\"},1161:{name:\"Duration\",type:\"Float\"},1121:{name:\"DateUTC\",type:\"Date\"},15273:{name:\"Title\",type:\"String\"},3456:{name:\"MuxingApp\",type:\"String\"},5953:{name:\"WritingApp\",type:\"String\"},"
			+ "103:{name:\"Timecode\",type:\"Uint\"},6228:{name:\"SilentTracks\",type:\"Container\"},6359:{name:\"SilentTrackNumber\",type:\"Uint\"},39:{name:\"Position\",type:\"Uint\"},43:{name:\"PrevSize\",type:\"Uint\"},35:{name:\"SimpleBlock\",type:\"Binary\"},32:{name:\"BlockGroup\",type:\"Container\"},33:{name:\"Block\",type:\"Binary\"},34:{name:\"BlockVirtual\",type:\"Binary\"},13729:{name:\"BlockAdditions\",type:\"Container\"},38:{name:\"BlockMore\",type:\"Container\"},110:{name:\"BlockAddID\",type:\"Uint\"},37:{name:\"BlockAdditional\",type:\"Binary\"},"
			+ "27:{name:\"BlockDuration\",type:\"Uint\"},122:{name:\"ReferencePriority\",type:\"Uint\"},123:{name:\"ReferenceBlock\",type:\"Int\"},125:{name:\"ReferenceVirtual\",type:\"Int\"},36:{name:\"CodecState\",type:\"Binary\"},13730:{name:\"DiscardPadding\",type:\"Int\"},14:{name:\"Slices\",type:\"Container\"},104:{name:\"TimeSlice\",type:\"Container\"},76:{name:\"LaceNumber\",type:\"Uint\"},77:{name:\"FrameNumber\",type:\"Uint\"},75:{name:\"BlockAdditionID\",type:\"Uint\"},78:{name:\"Delay\",type:\"Uint\"},79:{name:\"SliceDuration\",type:\"Uint\"},72:{name:\"ReferenceFrame\","
			+ "type:\"Container\"},73:{name:\"ReferenceOffset\",type:\"Uint\"},74:{name:\"ReferenceTimeCode\",type:\"Uint\"},47:{name:\"EncryptedBlock\",type:\"Binary\"},106212971:{name:\"Tracks\",type:\"Container\"},46:{name:\"TrackEntry\",type:\"Container\"},87:{name:\"TrackNumber\",type:\"Uint\"},13253:{name:\"TrackUID\",type:\"Uint\"},3:{name:\"TrackType\",type:\"Uint\"},57:{name:\"FlagEnabled\",type:\"Uint\"},8:{name:\"FlagDefault\",type:\"Uint\"},5546:{name:\"FlagForced\",type:\"Uint\"},28:{name:\"FlagLacing\",type:\"Uint\"},11751:{name:\"MinCache\",type:\"Uint\"},"
			+ "11768:{name:\"MaxCache\",type:\"Uint\"},254851:{name:\"DefaultDuration\",type:\"Uint\"},216698:{name:\"DefaultDecodedFieldDuration\",type:\"Uint\"},209231:{name:\"TrackTimecodeScale\",type:\"Float\"},4991:{name:\"TrackOffset\",type:\"Int\"},5614:{name:\"MaxBlockAdditionID\",type:\"Uint\"},4974:{name:\"Name\",type:\"String\"},177564:{name:\"Language\",type:\"String\"},6:{name:\"CodecID\",type:\"String\"},9122:{name:\"CodecPrivate\",type:\"Binary\"},362120:{name:\"CodecName\",type:\"String\"},13382:{name:\"AttachmentLink\",type:\"Uint\"},1742487:{name:\"CodecSettings\","
			+ "type:\"String\"},1785920:{name:\"CodecInfoURL\",type:\"String\"},438848:{name:\"CodecDownloadURL\",type:\"String\"},42:{name:\"CodecDecodeAll\",type:\"Uint\"},12203:{name:\"TrackOverlay\",type:\"Uint\"},5802:{name:\"CodecDelay\",type:\"Uint\"},5819:{name:\"SeekPreRoll\",type:\"Uint\"},9764:{name:\"TrackTranslate\",type:\"Container\"},9980:{name:\"TrackTranslateEditionUID\",type:\"Uint\"},9919:{name:\"TrackTranslateCodec\",type:\"Uint\"},9893:{name:\"TrackTranslateTrackID\",type:\"Binary\"},96:{name:\"Video\",type:\"Container\"},26:{name:\"FlagInterlaced\","
			+ "type:\"Uint\"},5048:{name:\"StereoMode\",type:\"Uint\"},5056:{name:\"AlphaMode\",type:\"Uint\"},5049:{name:\"OldStereoMode\",type:\"Uint\"},48:{name:\"PixelWidth\",type:\"Uint\"},58:{name:\"PixelHeight\",type:\"Uint\"},5290:{name:\"PixelCropBottom\",type:\"Uint\"},5307:{name:\"PixelCropTop\",type:\"Uint\"},5324:{name:\"PixelCropLeft\",type:\"Uint\"},5341:{name:\"PixelCropRight\",type:\"Uint\"},5296:{name:\"DisplayWidth\",type:\"Uint\"},5306:{name:\"DisplayHeight\",type:\"Uint\"},5298:{name:\"DisplayUnit\",type:\"Uint\"},5299:{name:\"AspectRatioType\","
			+ "type:\"Uint\"},963876:{name:\"ColourSpace\",type:\"Binary\"},1029411:{name:\"GammaValue\",type:\"Float\"},230371:{name:\"FrameRate\",type:\"Float\"},97:{name:\"Audio\",type:\"Container\"},53:{name:\"SamplingFrequency\",type:\"Float\"},14517:{name:\"OutputSamplingFrequency\",type:\"Float\"},31:{name:\"Channels\",type:\"Uint\"},15739:{name:\"ChannelPositions\",type:\"Binary\"},8804:{name:\"BitDepth\",type:\"Uint\"},98:{name:\"TrackOperation\",type:\"Container\"},99:{name:\"TrackCombinePlanes\",type:\"Container\"},100:{name:\"TrackPlane\",type:\"Container\"},"
			+ "101:{name:\"TrackPlaneUID\",type:\"Uint\"},102:{name:\"TrackPlaneType\",type:\"Uint\"},105:{name:\"TrackJoinBlocks\",type:\"Container\"},109:{name:\"TrackJoinUID\",type:\"Uint\"},64:{name:\"TrickTrackUID\",type:\"Uint\"},65:{name:\"TrickTrackSegmentUID\",type:\"Binary\"},70:{name:\"TrickTrackFlag\",type:\"Uint\"},71:{name:\"TrickMasterTrackUID\",type:\"Uint\"},68:{name:\"TrickMasterTrackSegmentUID\",type:\"Binary\"},11648:{name:\"ContentEncodings\",type:\"Container\"},8768:{name:\"ContentEncoding\",type:\"Container\"},4145:{name:\"ContentEncodingOrder\","
			+ "type:\"Uint\"},4146:{name:\"ContentEncodingScope\",type:\"Uint\"},4147:{name:\"ContentEncodingType\",type:\"Uint\"},4148:{name:\"ContentCompression\",type:\"Container\"},596:{name:\"ContentCompAlgo\",type:\"Uint\"},597:{name:\"ContentCompSettings\",type:\"Binary\"},4149:{name:\"ContentEncryption\",type:\"Container\"},2017:{name:\"ContentEncAlgo\",type:\"Uint\"},2018:{name:\"ContentEncKeyID\",type:\"Binary\"},2019:{name:\"ContentSignature\",type:\"Binary\"},2020:{name:\"ContentSigKeyID\",type:\"Binary\"},2021:{name:\"ContentSigAlgo\",type:\"Uint\"},"
			+ "2022:{name:\"ContentSigHashAlgo\",type:\"Uint\"},206814059:{name:\"Cues\",type:\"Container\"},59:{name:\"CuePoint\",type:\"Container\"},51:{name:\"CueTime\",type:\"Uint\"},55:{name:\"CueTrackPositions\",type:\"Container\"},119:{name:\"CueTrack\",type:\"Uint\"},113:{name:\"CueClusterPosition\",type:\"Uint\"},112:{name:\"CueRelativePosition\",type:\"Uint\"},50:{name:\"CueDuration\",type:\"Uint\"},4984:{name:\"CueBlockNumber\",type:\"Uint\"},106:{name:\"CueCodecState\",type:\"Uint\"},91:{name:\"CueReference\",type:\"Container\"},22:{name:\"CueRefTime\","
			+ "type:\"Uint\"},23:{name:\"CueRefCluster\",type:\"Uint\"},4959:{name:\"CueRefNumber\",type:\"Uint\"},107:{name:\"CueRefCodecState\",type:\"Uint\"},155296873:{name:\"Attachments\",type:\"Container\"},8615:{name:\"AttachedFile\",type:\"Container\"},1662:{name:\"FileDescription\",type:\"String\"},1646:{name:\"FileName\",type:\"String\"},1632:{name:\"FileMimeType\",type:\"String\"},1628:{name:\"FileData\",type:\"Binary\"},1710:{name:\"FileUID\",type:\"Uint\"},1653:{name:\"FileReferral\",type:\"Binary\"},1633:{name:\"FileUsedStartTime\",type:\"Uint\"},"
			+ "1634:{name:\"FileUsedEndTime\",type:\"Uint\"},4433776:{name:\"Chapters\",type:\"Container\"},1465:{name:\"EditionEntry\",type:\"Container\"},1468:{name:\"EditionUID\",type:\"Uint\"},1469:{name:\"EditionFlagHidden\",type:\"Uint\"},1499:{name:\"EditionFlagDefault\",type:\"Uint\"},1501:{name:\"EditionFlagOrdered\",type:\"Uint\"},54:{name:\"ChapterAtom\",type:\"Container\"},13252:{name:\"ChapterUID\",type:\"Uint\"},5716:{name:\"ChapterStringUID\",type:\"String\"},17:{name:\"ChapterTimeStart\",type:\"Uint\"},18:{name:\"ChapterTimeEnd\",type:\"Uint\"},"
			+ "24:{name:\"ChapterFlagHidden\",type:\"Uint\"},1432:{name:\"ChapterFlagEnabled\",type:\"Uint\"},11879:{name:\"ChapterSegmentUID\",type:\"Binary\"},11964:{name:\"ChapterSegmentEditionUID\",type:\"Uint\"},9155:{name:\"ChapterPhysicalEquiv\",type:\"Uint\"},15:{name:\"ChapterTrack\",type:\"Container\"},9:{name:\"ChapterTrackNumber\",type:\"Uint\"},0:{name:\"ChapterDisplay\",type:\"Container\"},5:{name:\"ChapString\",type:\"String\"},892:{name:\"ChapLanguage\",type:\"String\"},894:{name:\"ChapCountry\",type:\"String\"},10564:{name:\"ChapProcess\","
			+ "type:\"Container\"},10581:{name:\"ChapProcessCodecID\",type:\"Uint\"},1293:{name:\"ChapProcessPrivate\",type:\"Binary\"},10513:{name:\"ChapProcessCommand\",type:\"Container\"},10530:{name:\"ChapProcessTime\",type:\"Uint\"},10547:{name:\"ChapProcessData\",type:\"Binary\"},39109479:{name:\"Tags\",type:\"Container\"},13171:{name:\"Tag\",type:\"Container\"},9152:{name:\"Targets\",type:\"Container\"},10442:{name:\"TargetTypeValue\",type:\"Uint\"},9162:{name:\"TargetType\",type:\"String\"},9157:{name:\"TagTrackUID\",type:\"Uint\"},9161:{name:\"TagEditionUID\","
			+ "type:\"Uint\"},9156:{name:\"TagChapterUID\",type:\"Uint\"},9158:{name:\"TagAttachmentUID\",type:\"Uint\"},10184:{name:\"SimpleTag\",type:\"Container\"},1443:{name:\"TagName\",type:\"String\"},1146:{name:\"TagLanguage\",type:\"String\"},1156:{name:\"TagDefault\",type:\"Uint\"},1159:{name:\"TagString\",type:\"String\"},1157:{name:\"TagBinary\",type:\"Binary\"}};e.prototype.updateBySource=function(){};e.prototype.setSource=function(a){this.source=a;this.updateBySource()};e.prototype.updateByData=function(){};e.prototype.setData=function(a){this.data="
			+ "a;this.updateByData()};m(l,e);l.prototype.updateBySource=function(){this.data=\"\";for(var a=0;a<this.source.length;a++){var b=this.source[a].toString(16);this.data+=1===b.length%2?\"0\"+b:b}};l.prototype.updateByData=function(){var a=this.data.length/2;this.source=new Uint8Array(a);for(var b=0;b<a;b++){var c=this.data.substr(2*b,2);this.source[b]=parseInt(c,16)}};l.prototype.getValue=function(){return parseInt(this.data,16)};l.prototype.setValue=function(a){var b=this.setData;a=a.toString(16);b.call(this,"
			+ "1===a.length%2?\"0\"+a:a)};m(k,e);k.prototype.getFloatArrayType=function(){return this.source&&4===this.source.length?Float32Array:Float64Array};k.prototype.updateBySource=function(){var a=this.source.reverse();this.data=(new (this.getFloatArrayType())(a.buffer))[0]};k.prototype.updateByData=function(){var a=new (this.getFloatArrayType())([this.data]);this.source=(new Uint8Array(a.buffer)).reverse()};k.prototype.getValue=function(){return this.data};k.prototype.setValue=function(a){this.setData(a)};"
			+ "m(h,e);h.prototype.readByte=function(){return this.source[this.offset++]};h.prototype.readUint=function(){var a=this.readByte(),b=8-a.toString(2).length;a-=1<<7-b;for(var c=0;c<b;c++)a*=256,a+=this.readByte();return a};h.prototype.updateBySource=function(){this.data=[];for(this.offset=0;this.offset<this.source.length;this.offset=b){var a=this.readUint();b=this.readUint();var b=Math.min(this.offset+b,this.source.length),c=this.source.slice(this.offset,b),d=r[a]||{name:\"Unknown\",type:\"Unknown\"},f=e;"
			+ "switch(d.type){case \"Container\":f=h;break;case \"Uint\":f=l;break;case \"Float\":f=k}d=new f(d.name,d.type);d.setSource(c);this.data.push({id:a,idHex:a.toString(16),data:d})}};h.prototype.writeUint=function(a,b){for(var c=1,d=128;a>=d&&8>c;c++,d*=128);if(!b)for(a=d+a,b=c-1;0<=b;b--)d=a%256,this.source[this.offset+b]=d,a=(a-d)/256;this.offset+=c};h.prototype.writeSections=function(a){for(var b=this.offset=0;b<this.data.length;b++){var c=this.data[b],d=c.data.source,f=d.length;this.writeUint(c.id,a);this.writeUint(f,"
			+ "a);a||this.source.set(d,this.offset);this.offset+=f}return this.offset};h.prototype.updateByData=function(){var a=this.writeSections(\"draft\");this.source=new Uint8Array(a);this.writeSections()};h.prototype.getSectionById=function(a){for(var b=0;b<this.data.length;b++){var c=this.data[b];if(c.id===a)return c.data}return null};m(n,h);n.prototype.fixDuration=function(a,b){b=b.logger;var c=this.getSectionById(139690087);if(!c)return b(\"[fix-webm-duration] Segment section is missing\"),"
			+ "!1;var d=c.getSectionById(88713574);if(!d)return b(\"[fix-webm-duration] Info section is missing\"),!1;var f=d.getSectionById(710577);if(!f)return b(\"[fix-webm-duration] TimecodeScale section is missing\"),!1;var g=d.getSectionById(1161);if(g)if(0>=g.getValue())b(\"[fix-webm-duration] Duration section is present, but the value is empty\"),g.setValue(a);else return b(\"[fix-webm-duration] Duration section is present\"),!1;else b(\"[fix-webm-duration] Duration section is missing\"),g=new k(\"Duration\",\"Float\"),"
			+ "g.setValue(a),d.data.push({id:1161,data:g});f.setValue(1E6);d.updateByData();c.updateByData();this.updateByData();return!0};n.prototype.toBlob=function(a){return new Blob([this.source.buffer],{type:a||\"video/webm\"})};return p.default=p;")
	private static native JSObject register();

}
