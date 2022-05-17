# Visual Basic 6.0 Language Support

![Build](https://github.com/Tyrrx/vb6-language/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

[//]: # (## Template ToDo list)

[//]: # (- [x] Create a new [IntelliJ Platform Plugin Template][template] project.)

[//]: # (- [ ] Get known with the [template documentation][template].)

[//]: # (- [ ] Verify the [pluginGroup]&#40;/gradle.properties&#41;, [plugin ID]&#40;/src/main/resources/META-INF/plugin.xml&#41; and [sources package]&#40;/src/main/kotlin&#41;.)

[//]: # (- [ ] Review the [Legal Agreements]&#40;https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html&#41;.)

[//]: # (- [ ] [Publish a plugin manually]&#40;https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate&#41; for the first time.)

[//]: # (- [ ] Set the Plugin ID in the above README badges.)

[//]: # (- [ ] Set the [Deployment Token]&#40;https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html&#41;.)

[//]: # (- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.)

<!-- Plugin description -->
The classic Visual Basic 6.0 IDE is no longer supported as of April 8, 2008 ([Support Statement](https://docs.microsoft.com/en-us/previous-versions/visualstudio/visual-basic-6/visual-basic-6-support-policy)).
Nevertheless, there is still source code that needs to be maintained and developed.
For this reason we have decided to design a plugin for the development 
of VB6 source code for the IntelliJ platform. 
Our goal is to implement all the features that the Visual Basic 6.0 IDE Editor
already supports including some modern features like e.g. rename 
refactoring and semantic error highlighting (not yet supported).

So far the following functions are supported:

- Syntax highlighting (including basic syntax error highlighting)
- Navigation
- Rename refactoring
- Code completion (based on the code base only)
- Quick documentation
- Basic formatting

Not yet supported:

- Semantic errors/flaws highlighting (including quick fixes)
- Active project view
- Find usages
- Completion based on external code (including runtime)
- Editing forms
- Documentation preview
- Extended formatting
- Enhanced syntactic error highlighting
- Type inference of expressions
- Structure view
- Commenter
- Parameter info
- Folding
- Surround with
- Keyword completion
- Inlay hints
<!-- Plugin description end -->

## Installation

[//]: # (- Using IDE built-in plugin system:)

[//]: # (  )
[//]: # (  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "vb6-language"</kbd> >)

[//]: # (  <kbd>Install Plugin</kbd>)
  
- Manually:

  Download the [latest release](https://github.com/Tyrrx/vb6-language/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Usage

To use go to <kbd>Tools</kbd> > <kbd>Visual Basic 6.0</kbd> > <kbd>Attach Visual Basic 6.0 Project</kbd> 
and select a VB6 project file (.vbp).
Then open a class or module file and start developing.
The Visual Basic 6.0 project will stay attached after closing the IDE.

To detach a project go to <kbd>Tools</kbd> > <kbd>Visual Basic 6.0</kbd> > 
<kbd>Detach Visual Basic 6.0 Projects</kbd> and select the project to detach.

> NOTE: the plugin is still under heavy development

## Technical details

The plugin uses an ANTLRv4-Lexer and ANTLRv4-Parser to analyze the Visual Basic 6.0 source code.
The grammar which is used is derived from the 
community developed grammar found here: [vba grammar](https://github.com/antlr/grammars-v4/tree/master/vba).

To support the use of ANTLRv4 grammars for custom 
languages the [antlr4-intellij-adaptor](https://github.com/antlr/antlr4-intellij-adaptor)
is used to create the AST (it's a syntax tree without abstractions, but they call it AST).

References are resolved by traversing the PSI bottom-up using visitors.
The global scope is defined by the workspace service that contains all the loaded projects.


## Limitations
Yes.

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
