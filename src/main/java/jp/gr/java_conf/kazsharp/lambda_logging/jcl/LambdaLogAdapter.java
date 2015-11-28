/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package jp.gr.java_conf.kazsharp.lambda_logging.jcl;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.jcl.LogAdapter;
import org.apache.logging.log4j.spi.LoggerContext;

/**
 * Logオブジェクトを生成するためのクラス。
 *
 * @since 2.1
 */
public class LambdaLogAdapter extends LogAdapter {

	/*
	 * (非 Javadoc)
	 *
	 * @see org.apache.logging.log4j.jcl.LogAdapter#newLogger(java.lang.String,
	 * org.apache.logging.log4j.spi.LoggerContext)
	 */
	@Override
	protected Log newLogger(final String name, final LoggerContext context) {
		return new LambdaLog4jLog(context.getLogger(name));
	}

}
