/*
 *    Copyright 2013 APPNEXUS INC
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.appnexus.opensdkdemo.testviews;

import android.app.Activity;
import android.view.View;
import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.MediatedBannerAdViewController;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdkdemo.TestUtil;
import com.appnexus.opensdkdemo.mediationtests.TestMediationSuccess;

public class ThirdSuccessfulMediationView implements MediatedBannerAdView {
	public static boolean didPass = false;

	@Override
	public View requestAd(MediatedBannerAdViewController mBC, Activity activity, String parameter, String uid, int width, int height, View adSpace) {
		Clog.d(TestUtil.testLogTag, "3rd set to true!");
		didPass = true;

		Clog.d(TestUtil.testLogTag, "notifying lock");

		synchronized (TestMediationSuccess.lock) {
			TestMediationSuccess.lock.notify();
		}

		return null;
	}
}
