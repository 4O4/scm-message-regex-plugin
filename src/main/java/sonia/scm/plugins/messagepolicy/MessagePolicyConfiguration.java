/**
 * Copyright (c) 2010, Sebastian Sdorra
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name of SCM-Manager; nor the names of its
 *    contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * http://bitbucket.org/sdorra/scm-manager
 *
 */

package sonia.scm.plugins.messagepolicy;

import sonia.scm.Validateable;
import sonia.scm.PropertiesAware;
import sonia.scm.repository.Repository;
import sonia.scm.util.Util;

/**
 * 
 * @author Marvin Froeder marvin_at_marvinformatics_dot_com
 */
public class MessagePolicyConfiguration implements Validateable {

	public static final String PROPERTY_PATTERN_TEXT = "messagePolicy.pattern.text";
	public static final String PROPERTY_PATTERN_DOTALL = "messagePolicy.pattern.dotall";
	public static final String PROPERTY_PATTERN_MULTILINE = "messagePolicy.pattern.multiline";

	private String patternText;
	private boolean patternDotall;
	private boolean patternMultiline;

	public MessagePolicyConfiguration(Repository repository) {
		patternText = repository.getProperty(PROPERTY_PATTERN_TEXT);
		patternDotall = getBooleanProperty(repository, PROPERTY_PATTERN_DOTALL);
		patternMultiline = getBooleanProperty(repository, PROPERTY_PATTERN_MULTILINE);
	}

	private boolean getBooleanProperty(PropertiesAware repository, String key)
	{
		boolean result = false;
		String value = repository.getProperty(key);

		if (Util.isNotEmpty(value))
		{
			result = Boolean.parseBoolean(value);
		}

		return result;
	}
	public String getPatternText() {
		return patternText;
	}

	public boolean getPatternDotall() {
		return patternDotall;
	}

	public boolean getPatternMultiline() {
		return patternMultiline;
	}

	@Override
	public boolean isValid() {
		return Util.isNotEmpty(patternText);
	}

}
