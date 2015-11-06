using System;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Microsoft.Phone.Controls;
using System.Diagnostics;
using System.Runtime.Serialization;
using WPCordovaClassLib.Cordova;
using WPCordovaClassLib.Cordova.Commands;
using WPCordovaClassLib.Cordova.JSON;
using Microsoft.Phone.Shell;
using Microsoft.Phone.Tasks;

namespace WPCordovaClassLib.Cordova.Commands
{
    public class config_geo_plugin : BaseCommand
    {
        public void open()
        {
            Windows.System.Launcher.LaunchUriAsync(new Uri("ms-settings-bluetooth:"));
        }
    }
}
