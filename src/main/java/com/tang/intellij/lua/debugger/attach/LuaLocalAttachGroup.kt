/*
 * Copyright (c) 2017. tangzx(love.tangzx@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tang.intellij.lua.debugger.attach

import com.intellij.execution.process.ProcessInfo
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.UserDataHolder
import com.intellij.xdebugger.attach.XLocalAttachGroup
import com.tang.intellij.lua.lang.LuaIcons
import com.tang.intellij.lua.lang.LuaLanguage
import javax.swing.Icon

/**
 *
 * Created by tangzx on 2017/2/28.
 */
class LuaLocalAttachGroup : XLocalAttachGroup {

    override fun getOrder(): Int {
        return XLocalAttachGroup.DEFAULT.order - 10
    }

    override fun getGroupName(): String {
        return LuaLanguage.INSTANCE.id
    }

    override fun getProcessIcon(project: Project, processInfo: ProcessInfo, userDataHolder: UserDataHolder): Icon {
        return LuaIcons.FILE
    }

    override fun getProcessDisplayText(project: Project, processInfo: ProcessInfo, userDataHolder: UserDataHolder): String {
        return processInfo.executableName
    }

    override fun compare(project: Project, a: ProcessInfo, b: ProcessInfo, userDataHolder: UserDataHolder): Int {
        return XLocalAttachGroup.DEFAULT.compare(project, a, b, userDataHolder)
    }

    companion object {

        val INSTANCE = LuaLocalAttachGroup()
    }
}
