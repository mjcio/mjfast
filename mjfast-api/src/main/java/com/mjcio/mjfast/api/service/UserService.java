/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.mjcio.mjfast.api.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.mjcio.mjfast.api.entity.UserEntity;
import com.mjcio.mjfast.api.form.LoginForm;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * 
	 * @param form
	 *            登录表单
	 * @return 返回登录信息
	 */
	Map<String, Object> login(LoginForm form);
}
