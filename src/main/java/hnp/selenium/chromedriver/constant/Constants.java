package hnp.selenium.chromedriver.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public static final int PAGING_STEP = 1;
    public static final String CTBERR400 = "CTBERR400";
    public static final String CTBERR404 = "CTBERR404";
    public static final String CTBERR401 = "CTBERR401";
    public static final String RISKFREERATE = "RISKFREERATE";
    public static final String CTBERR403 = "CTBERR403";
    public static final String RESOURCE_ORIGIN = "D:\\test_img\\###.png";
    public static final String RESOURCE_ORIGIN_CUT = "D:\\test_img\\###_cut.png";
    public static final String SEARCH_NOT_FOUND = "Không tìm thấy kết quả !";
    public static final String CAPTCHA_NOT_MATCH = "Mã xác nhận sai!";
    public static final String URL_BASE = "https://www.csgt.vn/tra-cuu-phuong-tien-vi-pham.html";

    public static final String LICENSE_PLATES = "Biển kiểm soát";
    public static final String LICENSE_PLATES_COLOR = "Màu biển";
    public static final String TYPE_VEHICLE = "Loại phương tiện";
    public static final String VIOLATION_TIME = "Thời gian vi phạm";
    public static final String VIOLATION_LOCATION = "Địa điểm vi phạm";
    public static final String VIOLATION = "Hành vi vi phạm";
    public static final String STATUS = "Trạng thái";
    public static final String VIOLATION_DETECTION_UNIT = "Đơn vị phát hiện vi phạm";
    public static final String PLACE_TO_SOLVE = "Nơi giải quyết vụ việc";

    public static final String HTML5 = "<html><head><title>First parse</title></head>"
            + "<body>###</body></html>";
    public static final String DATA = "<div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Biển kiểm soát:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">30F-580.38</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Màu biển:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Nền mầu trắng, chữ và số màu đen</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Loại phương tiện:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Ô tô</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <div class=\"row\">\n" +
            "                        <label class=\"control-label col-md-3 text-right\">\n" +
            "                            <span>Thời gian vi phạm: </span>\n" +
            "                        </label>\n" +
            "                        <div class=\"col-md-9\">19:14, 16/11/2022</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Địa điểm vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Quán thánh- Thanh Niên, Phường Quán Thánh, Quận Ba Đình, Thành phố Hà Nội</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                            <div class=\"form-group\">\n" +
            "                    <div class=\"row\">\n" +
            "                        <label class=\"control-label col-md-3 text-right\">\n" +
            "                            <span>Hành vi vi phạm:</span>\n" +
            "                        </label>\n" +
            "                        <div class=\"col-md-9\">5.5.a.Không chấp hành hiệu lệnh của đèn tín hiệu giao thông</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Trạng thái: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">\n" +
            "                        <span class=\"badge text-danger\">Chưa xử phạt</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Đơn vị phát hiện vi phạm: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Đội Chỉ huy giao thông và điều khiển đèn tín hiệu giao thông - PHÒNG CẢNH SÁT GIAO THÔNG HÀ NỘI</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Nơi giải quyết vụ việc: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\"></div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">1. Đội Chỉ huy giao thông và điều khiển đèn tín hiệu giao thông - PHÒNG CẢNH SÁT GIAO THÔNG HÀ NỘI</div>\n" +
            "                        <div class=\"form-group\">Địa chỉ: 54 Trần Hưng Đạo, P. Hàng Bài, Q. Hoàn Kiếm, Tp. Hà Nội</div>\n" +
            "            \n" +
            "            \n" +
            "                        <div class=\"form-group\">2. Đội Cảnh sát giao thông, Trật tự huyện Gia Lâm - Công an huyện Gia Lâm - Thành phố Hà Nội</div>\n" +
            "\n" +
            "            \n" +
            "            \n" +
            "                        <hr style=\"margin-bottom: 25px;\">\n" +
            "\t\t\t\t\t\t<div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Biển kiểm soát:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">30F-580.38</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Màu biển:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Nền mầu trắng, chữ và số màu đen</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Loại phương tiện:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Ô tô</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <div class=\"row\">\n" +
            "                        <label class=\"control-label col-md-3 text-right\">\n" +
            "                            <span>Thời gian vi phạm: </span>\n" +
            "                        </label>\n" +
            "                        <div class=\"col-md-9\">14:14, 19/05/2022</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Địa điểm vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Km12+800</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                            <div class=\"form-group\">\n" +
            "                    <div class=\"row\">\n" +
            "                        <label class=\"control-label col-md-3 text-right\">\n" +
            "                            <span>Hành vi vi phạm:</span>\n" +
            "                        </label>\n" +
            "                        <div class=\"col-md-9\">Điều khiển xe chạy quá tốc độ quy định trên 20km/h đến 35 km/h</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Trạng thái: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">\n" +
            "                        <span class=\"badge text-danger\">Chưa xử phạt</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Đơn vị phát hiện vi phạm: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Đội TTKSGTĐB số 1, Phòng 8 - Cục Cảnh sát giao thông</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Nơi giải quyết vụ việc: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\"></div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">1. Đội TTKSGTĐB số 1, Phòng 8 - Cục Cảnh sát giao thông</div>\n" +
            "                        <div class=\"form-group\">Địa chỉ: Đội TTKSGTĐB cao tốc số 1</div>\n" +
            "            \n" +
            "                        <div class=\"form-group\">Số điện thoại liên hệ: 02435816399</div>\n" +
            "            \n" +
            "                        <hr style=\"margin-bottom: 25px;\">\n" +
            "\t\t\t\t\t\t<div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Biển kiểm soát:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">30F-580.38</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Màu biển:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Nền mầu trắng, chữ và số màu đen</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Loại phương tiện:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Ô tô</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <div class=\"row\">\n" +
            "                        <label class=\"control-label col-md-3 text-right\">\n" +
            "                            <span>Thời gian vi phạm: </span>\n" +
            "                        </label>\n" +
            "                        <div class=\"col-md-9\">10:17, 11/09/2020</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Địa điểm vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Km85+880, Cao tốc Nội Bài - Lào Cai</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Trạng thái: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">\n" +
            "                        <span class=\"badge text-danger\">Chưa xử phạt</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Đơn vị phát hiện vi phạm: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Đội TTKSGTĐB số 1, Phòng 8 - Cục Cảnh sát giao thông</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Nơi giải quyết vụ việc: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\"></div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">1. Đội TTKSGTĐB số 1, Phòng 8 - Cục Cảnh sát giao thông</div>\n" +
            "                        <div class=\"form-group\">Địa chỉ: Đội TTKSGTĐB cao tốc số 1</div>\n" +
            "            \n" +
            "                        <div class=\"form-group\">Số điện thoại liên hệ: 02435816399</div>\n" +
            "            \n" +
            "                        <hr style=\"margin-bottom: 25px;\">\n" +
            "\t\t\t\t\t\t<div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Biển kiểm soát:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">30F-580.38</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Màu biển:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Nền mầu trắng, chữ và số màu đen</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Loại phương tiện:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Ô tô</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                <div class=\"form-group\">\n" +
            "                    <div class=\"row\">\n" +
            "                        <label class=\"control-label col-md-3 text-right\">\n" +
            "                            <span>Thời gian vi phạm: </span>\n" +
            "                        </label>\n" +
            "                        <div class=\"col-md-9\">12:37, 17/09/2020</div>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Địa điểm vi phạm:</span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Hà Tĩnh</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "                        <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Trạng thái: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">\n" +
            "                        <span class=\"badge text-danger\">Đã xử phạt</span>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Đơn vị phát hiện vi phạm: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\">Phòng CSGT, Công an  Hà Tĩnh</div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <div class=\"row\">\n" +
            "                    <label class=\"control-label col-md-3 text-right\">\n" +
            "                        <span>Nơi giải quyết vụ việc: </span>\n" +
            "                    </label>\n" +
            "                    <div class=\"col-md-9\"></div>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">1. Phòng CSGT, Công an  Hà Tĩnh</div>\n" +
            "                        <div class=\"form-group\">Địa chỉ: Thạch Trung, TP Hà Tĩnh</div>\n" +
            "            \n" +
            "                        <div class=\"form-group\">Số điện thoại liên hệ: 0692.928340</div>\n" +
            "            \n" +
            "                        <hr style=\"margin-bottom: 25px;\">";
}
