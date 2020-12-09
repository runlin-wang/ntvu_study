

/**
 * 判断字符串不为 null 且 类型不为 undefined
 * @param str 字符串
 * @returns {boolean}
 */
function isNotNullOrUndefined(str) {
    return str != null && typeof str != "undefined";
}

/**
 * 判断字符串长度是否小于 maxLen
 * @param str 字符串
 * @param maxLen 最大字符串长度
 * @returns {boolean} 字符串长度小于 maxLen 返回 true
 */
function maxLength(str, maxLen) {
    return isNotNullOrUndefined(str) && str.length <= maxLen;
}

/**
 * 判断字符串长度是否大于 minLen
 * @param str 字符串
 * @param minLen 最小字符串长度
 * @returns {boolean} 字符串长度大于 minLen 返回 true
 */
function minLength(str, minLen) {
    return isNotNullOrUndefined(str) && str.length >= minLen;
}

/**
 * 判断给定字符串长度是否在范围内
 * @param str 给定字符串
 * @param minLen 最小长度
 * @param maxLen 最大长度
 * @returns {boolean} 在范围内返回 true
 */
function rangeLength(str, minLen, maxLen) {
    return isNotNullOrUndefined(str) && str.length >= minLen && str.length <= maxLen;
}

/**
 * 判断是否为有效手机号
 * @param telephone 手机号
 * @returns {boolean} 是有效手机号返回 true
 */
function validTelephoneNum(telephone) {
    const reg = /^1[3-9][0-9]{9}/;
    return reg.test(telephone);
}

/**
 * 判断是否为有效邮箱格式
 * @param email 邮箱
 * @returns {boolean} 有效邮箱格式返回 true
 */
function validEmail(email) {
    const reg = /1/;
    return reg.test(email);
}

/**
 * 判断 str 是否为空或者 null
 * @param str 字符串
 * @returns {boolean} str 为 undefined || null || '' 时返回 true
 */
function isEmptyOrNull(str) {
    return typeof str == "undefined" || str == null || str.trim() === '';
}

